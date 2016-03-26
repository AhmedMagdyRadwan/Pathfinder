package jaci.pathfinder.modifiers;

import jaci.pathfinder.PathfinderJNI;
import jaci.pathfinder.Trajectory;

public class SwerveModifier {

    public static enum Mode {
        SWERVE_DEFAULT
    }

    Trajectory source, fl, fr, bl, br;

    public SwerveModifier(Trajectory source) {
        this.source = source;
    }

    public SwerveModifier modify(double wheelbase_width, double wheelbase_depth, Mode mode) {
        Trajectory[] trajs = PathfinderJNI.modifyTrajectorySwerve(source, wheelbase_width, wheelbase_depth, mode);
        fl = trajs[0];
        fr = trajs[1];
        bl = trajs[2];
        br = trajs[3];
        return this;
    }

    public Trajectory getSourceTrajectory() {
        return source;
    }

    public Trajectory getFrontLeftTrajectory() {
        return fl;
    }

    public Trajectory getFrontRightTrajectory() {
        return fr;
    }

    public Trajectory getBackLeftTrajectory() {
        return bl;
    }

    public Trajectory getBackRightTrajectory() {
        return br;
    }

}