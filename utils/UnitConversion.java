package bow.utils;

public class UnitConversion {
    // Temperature Conversions
    public static double celciusToFahrenheit(double cel_input){
        return (cel_input * 1.8) + 32.0;
    }
    public static double fahrenheitToCelcius(double fah_input){
        return (fah_input - 32.0) / 1.8;
    }

    // Distance Conversions
    public static double inchToMeter(double inch_input){
        return inch_input * 0.0254;
    }
    public static double MeterToInch(double meter_input){
        return meter_input / 0.0254;
    }
    
    // Speed Conversions
    public static double rpmToRadsPerSecond(double rpm_input) {
        return rpm_input * 2.0 * Math.PI / 60.0;
    }
    public static double radsPerSecondToRPM(double rads_input) {
        return rads_input * 60.0 / (2.0 * Math.PI);
    }

}