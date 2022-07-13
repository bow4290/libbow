package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import com.revrobotics.CANSparkMax;
// import com.revrobotics.RelativeEncoder;
// import com.revrobotics.CANSparkMax.FaultID;
// import com.revrobotics.CANSparkMax.IdleMode;
// import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import bow.sensors.Limelight;

public class TurretSubsystem extends SubsystemBase {
  // private CANSparkMax motor;
  // public RelativeEncoder encoder;
  private Limelight limelight;
  public boolean isTurretStopped = false;
  public double homingPosition = 0;
  private int deviceID;
  private int forwardRotations;
  private int reverseRotations;
  private double aimOffsetDistance;
  // NOTE: Already commented out
  // private SparkMaxPIDController pid;

  // NOTE: Already commented out
  // private double kP, kI, kD, kF, kMaxOutput, kMinOutput, setpoint;

  public TurretSubsystem(Limelight limelight, int deviceID, int forwardRotations, int reverseRotations, double aimOffsetDistance) {
    this.deviceID = deviceID;
    this.forwardRotations = forwardRotations;
    this.reverseRotations = reverseRotations;
    this.aimOffsetDistance = aimOffsetDistance;

    this.limelight = limelight;

    // motor = new CANSparkMax(deviceID, MotorType.kBrushless);
    // motor.restoreFactoryDefaults();

    // motor.setInverted(false);
    // motor.setIdleMode(IdleMode.kBrake);
    // motor.enableVoltageCompensation(11.0);

    // motor.enableSoftLimit(CANSparkMax.SoftLimitDirection.kForward, true);
    // motor.enableSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, true);

    // motor.setSoftLimit(CANSparkMax.SoftLimitDirection.kForward, forwardRotations);
    // motor.setSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, reverseRotations);

    // NOTE: Already commented out
    // pid = motor.getPIDController();


    // encoder = motor.getEncoder();
    // encoder.setPosition(0);
  }

  public void turnTurret(double speed){
    // motor.set(speed);
  }
  public void stopTurret(){
    // motor.set(0);
  }

  public boolean getHitLeftLimitSwitch() {
    // return motor.getFault(FaultID.kSoftLimitRev);
  }

  public boolean getHitRightLimitSwitch() {
    // return motor.getFault(FaultID.kSoftLimitFwd);
  }

  public boolean isTurretReady(){
    return (limelight.isTarget() && (Math.abs(limelight.getXErrorWithOffset(aimOffsetDistance)) < 3)); // was 2.5
  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Is Turret Ready? ", isTurretReady());
    SmartDashboard.putBoolean("Has a target? ", limelight.isTarget());
    SmartDashboard.putNumber("X Error ", limelight.getXErrorWithOffset(aimOffsetDistance));
    SmartDashboard.putNumber("Y Error ", limelight.getYError());
    SmartDashboard.putNumber("Distance ", limelight.getDistance());
  }
}
