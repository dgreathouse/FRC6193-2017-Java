# FRC6193-2017-Java
FRC 2017 Robot Code in Java

This code is used to drive the 2017 FRC robot for the 6193 team.
The robot is configured as follows.

Subsystems
1. Driveline
   4 independent mecanum wheels with 8.45:1 gearboxes driven by CIM motors
   1 Gyro for angle measurement
   1 front facing Axis camera
2. Fuel Shooter
   Two 775Pro motors driving 4 four inch wheels on a single shaft for shooting fuel
   4 independently driven fuel loaders that hold fuel back from entering shooter wheels
   2 linear servos that a adjust a deflector plate for changing the fuel flight path.
   A lexan box that holds around 30 fuel balls in four independent lanes.
   The fuel shooter shoots fuel from the rear of the robot over the front of the robot.
3. Fuel Intake
   A front facing vertical lift system driven by 1 Mini CIM. The lift collects fuel off 
   the floor and uses pulley to make the fuel travel up the Fuel Tank and drop into the fuel tank
   The fuel intake is around 20 inches wide to accomadate 4 fuel balls at a time.
4. Gear Grabber
   A field gear grabber that pick gears up off the floor. This gear grabbers uses a motor that spins connected gears
   that have attached pinchers. When the gear is pinched a USB camera is used to show the co-driver that the gear is ready
   to be lifted off the ground.  The gear spinner motor and gear lift motor are both KOP window motors. 
   The Gear Grabber is mounted on the Right side of the robot.
5. Rope Climber
   The rope climber uses a CIM motor with a 16:1 versa gearbox. The rope latching mechanism uses a gravity enabled hook and latch
   system to make the rope wind on itself while the motor rotates the attached 1/2 hex shaft.
   The Rope Climber is mounted on the left side of the robot.
