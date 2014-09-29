package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;

public class Object_OrientedDesign8_04 {
//Designing a parking lot using object-oriented principles.
	public enum VehicleSize {Motorcycle, Compact, Large}
	
	public abstract class Vehicle{
		protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();
		protected String licensePlate;
		protected int spotsNeeded;
		protected VehicleSize size;
		public int getSpotsNeeded(){
			
			return spotsNeeded;
		}
		
		public VehicleSize getSize(){
			return size;
		}
		
//		Park vehicle in this spot (among others, potentially)
		public void parkInSpot(ParkingSpot s){
			parkingSpots.add(s);
		}
		
		public void clearSpots(){
			
		}
		
		public abstract boolean canFitInSpot(ParkingSpot spot);
	}
	
	public class Bus extends Vehicle{
		public Bus(){
			spotsNeeded = 5;
			size = VehicleSize.Large;
		}

		public boolean canFitInSpot(ParkingSpot spot) {
			return false;
		}
	}
	
	public class Car extends Vehicle{
		public Car(){
			spotsNeeded = 1;
			size = VehicleSize.Compact;
		}

		public boolean canFitInSpot(ParkingSpot spot) {
			return false;
		}
		
	}
	
	public class MotorCycle extends Vehicle{
		public MotorCycle() {
			spotsNeeded = 1;
			size = VehicleSize.Motorcycle;
		}

		public boolean canFitInSpot(ParkingSpot spot) {
			return false;
		}
		
	}
	
	public class ParkingLot{
		private Level[] levels;
		private final int NUM_LEVELS = 5;
		public ParkingLot(){
			
		}
		public boolean parkVehicle(Vehicle vehicle){
			return false;
		}
		
		public class Level{
			private int floor;
			private ParkingSpot[] spots;
			private int availableSpots = 0;
			private static final int SPOTS_PER_ROW = 10;
			
			public Level(int flr, int numberSpots){
				floor = flr;
				availableSpots = numberSpots;
			}
			public int availableSpots(){
				return availableSpots;
			}
			
			public boolean parkVehicle(Vehicle vehicle){
				return false;
			}
			
			private boolean parkStartingAtSpot(int num, Vehicle v){
				return false;
			}
			
			private int findAvailableSpots(Vehicle vehicle){
				return 0;
			}
			
			public void spotFreed(){
				availableSpots++;
			}
		}
	}
	
	public class ParkingSpot{
		private Vehicle vehicle;
		private VehicleSize spotSize;
		private int row;
		private int spotNumbers;
		private Level level;
		
		public ParkingSpot(Level lvl, int r, int n, VehicleSize s){
			level = lvl;
			row = r;
			spotNumbers = n;
			spotSize = s;
		}
		
		public boolean isAvailable(){
			return vehicle == null;
		}
		
		public boolean canFitVehicle(Vehicle vehicle){
			return false;
		}
		
		public boolean park(Vehicle v){
			return false;
		}
		
		public int getRow(){
			return row;
		}
		
		public int getSpotNumber(){
			return spotNumbers;
		}
		
		public void removeVehicle(){
			
		}
	}
}
