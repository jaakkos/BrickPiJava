package com.ergotech.brickpi.sensors;

/**
 * An enumeration of sensor types.  The main thing we need to know to operate a sensor
 * is its type id and the number of bits that the sensor decodes on update.
 * @author sdaubin
 *
 */
public enum SensorType implements ISensorType {
    
    Raw(                    0, 10),
    LightOff(               0, 10),
    LightOn(                (Sensor.MASK_D0_M | Sensor.MASK_D0_S), 10),
    Touch(                  32, 1),
    Ultrasonic(             33, 8),
    UltrasonicSS(           34, 8),
    ColorFull(              36, 3),
    /**
     * Reflected light intensity (0 to 100).
     */
    EV3ColorReflected(      50, 16),
    /**
     * Ambient light intensity (0 to 100)
     */
    EV3ColorAmbient(        51, 16),
    /**
     * Detected color.
     * @see Color
     */
    EV3Color(               52, 16),
    EV3ColorRawReflected(   53, 32),
    /**
     * Raw Color Components.
     */
    EV3ColorRawColor(       54, 16),
    EV3Touch(               67, 16),      
    /**
     * Continuous measurement, distance, cm
     */
    EV3UltrasoundCm(43, 16),  //TYPE_SENSOR_EV3_US_M0 = 43;
    /**
     * Continuous measurement, distance, in
     */
    EV3UltrasoundIn(44,16), //TYPE_SENSOR_EV3_US_M1 = 44; 
    /**
     * Listen // 0 r 1 depending on presence of another US sensor.
     */
    //Zero idea if we need to add these.
    // TYPE_SENSOR_EV3_US_M2 = 45;
    // TYPE_SENSOR_EV3_US_M3 = 46;
    // TYPE_SENSOR_EV3_US_M4 = 47;
    // TYPE_SENSOR_EV3_US_M5 = 48;
    // TYPE_SENSOR_EV3_US_M6 = 49;

    // http://www.ev3dev.org/docs/sensors/lego-ev3-color-sensor/
    /**
     * Reflected light intensity (0 to 100)
     */
    EV3ColorIntensity(50,16), //TYPE_SENSOR_EV3_COLOR_M0 = 50;
    /**
     * Angle
     */
    EV3GyroAngle(56,16), //TYPE_SENSOR_EV3_GYRO_M0 = 56;
    
    /**
     * Rotational Speed
     */
    EV3GyroSpeed(57,16),  //TYPE_SENSOR_EV3_GYRO_M1 = 57;
    /**
     * Raw sensor value ???
     */
    EV3GyroRaw(58,16), // TYPE_SENSOR_EV3_GYRO_M2 = 58;
    /**
     * Angle and Rotational Speed?
     */
    EV3GyroAngleSpeed(59,16), //TYPE_SENSOR_EV3_GYRO_M3 = 59;
    /**
     * Calibration ???
     */
    EV3GyroCalibration(60,16), //TYPE_SENSOR_EV3_GYRO_M4 = 60;

    // Mode information is here:  http://www.ev3dev.org/docs/sensors/lego-ev3-infrared-sensor/
    /**
     * Proximity, 0 to 100
     */                            
    EV3IRProximity(61,16), //TYPE_SENSOR_EV3_INFRARED_M0 = 61;
    /**
     * IR Seek, -25 (far left) to 25 (far right)
     */
    EV3IRSeek(62,16), //TYPE_SENSOR_EV3_INFRARED_M1 = 62;
    /**
     * IR Remote Control, 0 - 11
     */
    //16 * 4 ?
    EV3IRRemote(63,64);  //TYPE_SENSOR_EV3_INFRARED_M2 = 63;
    //unused?
    // TYPE_SENSOR_EV3_INFRARED_M3 = 64;
    // TYPE_SENSOR_EV3_INFRARED_M4 = 65;
    // TYPE_SENSOR_EV3_INFRARED_M5 = 66;

    
    private final byte type;
    private final int decodeBitCount;
    
    private SensorType(int type, int decodeBitCount) {
        this.type = (byte)type;
        this.decodeBitCount = decodeBitCount;
    }

    //altered to conform to interface
    public byte getType() {
        return type;
    }
    //altered to conform to interface
    public int getDecodeBitCount() {
        return decodeBitCount;
    }
}
