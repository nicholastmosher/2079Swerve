package frc.robot.commands.Arm;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.lib.Constants;
import frc.robot.subsystems.Arm;

public class IntakePosition extends Command {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    Arm arm;

    public IntakePosition(Arm subsystem) {
        arm = subsystem;
        addRequirements(arm);
    }

    @Override
    public void execute() {
        Rotation2d angle = Rotation2d.fromDegrees(arm.config.intakeAngle);
        arm.setAngle(angle);
    }

    @Override
    public void end(boolean interrupted) {
        arm.stopSet();
    }

    @Override
    public boolean isFinished() {
        Rotation2d angle = new Rotation2d(arm.config.intakeAngle);
        return arm.endCondition(angle);
    }

}
