package org.usfirst.frc.team4956.robot.subsystems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team4956.robot.commands.GripPipeline;




import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode.PixelFormat;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionPipeline;
import edu.wpi.first.wpilibj.vision.VisionThread;


public class Camera extends Subsystem {
	
	public static final int IMG_WIDTH = 320;
	public static final int IMG_HEIGHT = 240;
	
	private VisionThread visionThread;
	private Rect rect1 = null;
	private Rect rect2 = null;
	
	private final Object imgLock = new Object();

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public double centerX() {
    	synchronized (imgLock) {
	    	double result = 0;
	    	Rect leftrect = null;
	    	Rect rightrect = null;
	    	if (rect1 != null && rect2 == null) {
	    		result = rect1.x + (rect1.width / 2);
	    		SmartDashboard.putString("DB/String 8", String.format("Only found 1 rect %d, %d", rect1.x, rect1.width));
	    	}
	    	else if (rect1 != null && rect2 != null)  {
	    		if (rect1.x <= rect2.x) {
	    			leftrect = rect1;
	    			rightrect = rect2;
	    		}
	    		else {
	    			
	    			leftrect = rect2;
	    			rightrect = rect1;
	    		}
	    		SmartDashboard.putString("DB/String 8", String.format("Left rect %d, %d", leftrect.x, leftrect.width));
	    		SmartDashboard.putString("DB/String 9", String.format("Right rect %d, %d", rightrect.x, rightrect.width));
	    		result = rightrect.x - ((rightrect.x - (leftrect.x + leftrect.width))/2); 
	    	}
	    	else {
	    		SmartDashboard.putString("DB/String 8", "No rect :-(");
	    		result = 0;
	    	}
	    	return result;
    	}
    }
    public double totalWidth() {
    	if (rect1 == null) {
    		return 0;
    	}
    	else if (rect2 == null) {
    		return rect1.width;
    	}
    	else {
    		return rect1.width + rect2.width;
    	}
    }
    public int totalRects() {
    	return rect1 != null ? (rect2 != null ? 2 : 1) : 0; 
    	
    }
    public static final Comparator<MatOfPoint> SIZE = (MatOfPoint o1, MatOfPoint o2) -> Double.compare(Imgproc.boundingRect(o1).area(), Imgproc.boundingRect(o2).area());
    public void startCapture() {
    	UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
    	
    	camera.setExposureManual(0);
    	camera.setWhiteBalanceManual(0);
    	camera.setBrightness(0);
    	
    	camera.setResolution(IMG_WIDTH, IMG_HEIGHT);
    	
    	 visionThread = new VisionThread(camera, new GripPipeline(), pipeline -> {
    		 rect1 = null;
    		 rect2 = null;
    	        if (!pipeline.convexHullsOutput().isEmpty()) {
    	        	
    	        	//Get BIGEST 2 rectangles 
    	        	Collections.sort(pipeline.convexHullsOutput(),SIZE); 
    	        	Collections.reverse(pipeline.convexHullsOutput());
    	        	
    	        	nContours = pipeline.findContoursOutput().size();
    	     
    	            synchronized (imgLock) {
    	            	 rect1 = Imgproc.boundingRect(pipeline.convexHullsOutput().get(0));
    	            } 
    	          
    	            if (pipeline.convexHullsOutput().size() > 1) {
        	            synchronized (imgLock) {
        	            	rect2 = Imgproc.boundingRect(pipeline.convexHullsOutput().get(1));
        	            }
    	            }
    	        }
    	    });
    	 visionThread.start();
    }
    
    int nContours = 0;
    public int getNContours() {
    	return nContours;
    }
    
    public void startCapture2() {
    	
    	UsbCamera usbCamera = new UsbCamera("USB Camera 0", 0);

    	MjpegServer mjpegServer1 = new MjpegServer("serve_USB Camera 0", 1181);
    	mjpegServer1.setSource(usbCamera); 
    	
    	CvSink cvSink = new CvSink("opencv_USB Camera 0");

    	cvSink.setSource(usbCamera);
    	CvSource outputStream = new CvSource("Blur", PixelFormat.kMJPEG, 640, 480, 30);
    	
    	MjpegServer mjpegServer2 = new MjpegServer("serve_Blur", 1182);
    	mjpegServer2.setSource(outputStream);
    }
}
