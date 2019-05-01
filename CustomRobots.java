/*Maia Mandel :)
Ms. Krasteva
2018. 01. 16
In this program, the user can create a robot by choosing customization options. Splash screen introduces the program to the user
and shows an animation. Main menu controls the flow of the program. By pressing 'a' they can start creating a robot.
The methods robotBody, robotFace, robotAntennae, are used for this. Then, display shows them the final product and allows them
to save it by giving it a name. That way if they go to openChoice, they can open it again later, and then delete it if they have the
password to the method adminMode. Goodbye exits the program while showing a quick picture.

	       VARIABLES
    NAME        TYPE        DESCRIPTION
    --------------------------------------------------
    background          color (int)    This variable sets the background color for the whole code
    continueChoice      char           controls the program flow
    customizeChocie     char           controls the program flow for the customization pages
    robotBodyChoice     char           holds the user's choice for the robot's body
    robotFaceChoice     char           holds the user's choice for the robot's face
    robotAntennaeChoice char           holds the user's choice for the robot's antennae
    finalRobot          string         holds the final choices for the robots in words
    robotName           string         holds the robots name
    robotName           string         create a file name for the robot using the name the user gave it
*/

import java.awt.*;
import hsa.Console; //import java class
import javax.swing.JOptionPane; //imports the J pane console
import java.io.*; //import java files
import javax.imageio.ImageIO; //import images
import java.awt.image.*; //import images

public class CustomRobots
{
    Console c;           // The output console

    Color background = new Color (201, 235, 255);
    char continueChoice = ' ';
    char customizeChoice = ' ';
    char robotBodyChoice = ' ';
    char robotFaceChoice = ' ';
    char robotAntennaeChoice = ' ';
    String finalRobot = " ";
    String robotName = " ";
    String fileName = " ";

    public CustomRobots ()
    {
	c = new Console (); //creates a new instance of Console for the user by the class
    }


    /* This method will clear the screen of every method that uses it,
    and writes the name of the program at the top.
    ----------------------------------------------------------
    Local Variables:
    NAME        TYPE        DESCRIPTION
    ----------------------------------------------------------
    title       int (color) creates a color for the title*/
    private void title ()
    {
	Color title = new Color (41, 118, 242); //one time variable to set the colour of the title
	c.clear (); //clears screen
	c.setColor (background);
	c.fillRect (0, 0, 640, 500);
	c.setColor (title);
	c.setFont (new Font ("Times New Roman", 3, 25));
	c.drawString ("Build-a-Bot", 260, 30);

    }


    /* This method will pause the program by making the user
    input a character in order to continue. */
    private void pauseProgram ()
    {
	c.setColour (Color.black);
	c.setFont (new Font ("Times New Roman", 1, 16));
	c.drawString ("Press any key to continue...", 235, 450);
	continueChoice = c.getChar ();
    }


    /* This method will introduce the user to the program by showing
    them a quick animation and decribing what the program does.
    ----------------------------------------------------------
    Local Variables:
    NAME        TYPE        DESCRIPTION
    ----------------------------------------------------------
    mouse       int (color) creates a color for the mouse
    darkMouse   int (color) creates a darker color for the mouse
    ----------------------------------------------------------
    The for loops animate the mouse and allows it to move in muliple directions.*/
    public void splashScreen ()
    {
	title (); //clear screen and display title
	Color mouse = new Color (232, 225, 225);
	Color darkMouse = new Color (201, 193, 193);
	c.setColour (Color.black);
	c.setFont (new Font ("Times New Roman", 1, 16));
	c.drawString ("Welcome to Build-a-Bot! This program will allow you to customize your dream robot!", 30, 100);
	for (int x = 0 ; x < 270 ; x++)
	{
	    c.setColor (background); //erase colour
	    c.fillOval (488 - (x - 60), 370 - x, 75, 133); //erase mouse base
	    c.setColor (darkMouse);
	    c.fillOval (500 - (x - 60), 400 - x, 60, 90); //mouse base
	    c.setColor (mouse);
	    c.fillArc (502 - (x - 60), 400 - x, 56, 70, 0, 180); //top part of mouse
	    c.setColor (Color.black);
	    c.drawOval (500 - (x - 60), 400 - x, 59, 90); //mouse outline
	    c.drawLine (530 - (x - 60), 400 - x, 530 - (x - 60), 490 - x); //middle line
	    c.drawLine (500 - (x - 60), 435 - x, 559 - (x - 60), 435 - x); //horizontal line
	    c.drawArc (525 - (x - 60), 390 - x, 5, 10, 270, 180); //first wire
	    c.drawArc (525 - (x - 60), 380 - x, 5, 10, 160, 160); //second wire
	    c.drawArc (520 - (x - 60), 372 - x, 5, 11, 320, 160); //third wire
	    c.setColor (Color.white);
	    c.fillOval (525 - (x - 60), 415 - x, 11, 20); //scroller
	    //delay
	    try
	    {
		Thread.sleep (10);
	    }
	    catch (Exception e)
	    {
	    }
	}
	c.setColor (mouse);
	c.fillArc (291, 131, 56, 70, 0, 180); //top part of mouse
	c.setColor (Color.gray);
	c.fillArc (291, 131, 60, 70, 90, 90); //clicked top part of mouse
	c.setColor (Color.black);
	c.drawArc (291, 131, 60, 70, 90, 90); //clicked top part of mouse
	c.setColor (Color.white);
	c.fillOval (315, 145, 11, 20); //scroller
	//delay
	try
	{
	    Thread.sleep (1000);
	}
	catch (Exception e)
	{
	}
	for (int x = 0 ; x < 100 ; x++)
	{
	    c.setColor (background); //erase colour
	    c.fillOval (278, 100 + x, 75, 133); //erase mouse base
	    //antennae
	    c.setColor (Color.black);
	    c.drawLine (312, 193, 312, 138); //left base line
	    c.drawLine (312, 138, 282, 138);
	    c.drawLine (282, 138, 282, 163);
	    c.drawLine (282, 163, 305, 163);
	    c.drawLine (305, 163, 305, 145);
	    c.drawLine (305, 145, 289, 145);
	    c.drawLine (289, 145, 289, 156);
	    c.drawLine (289, 156, 300, 156);
	    c.drawLine (300, 156, 300, 153);
	    c.drawLine (328, 193, 328, 138); //right base line
	    c.drawLine (328, 138, 358, 138);
	    c.drawLine (358, 138, 358, 163);
	    c.drawLine (358, 163, 336, 163);
	    c.drawLine (336, 163, 336, 145);
	    c.drawLine (336, 145, 352, 145);
	    c.drawLine (352, 145, 352, 156);
	    c.drawLine (352, 156, 341, 156);
	    c.drawLine (341, 156, 341, 153);
	    c.setColor (darkMouse);
	    c.fillOval (290, 130 + x, 60, 90); //mouse base
	    c.setColor (mouse);
	    c.fillArc (291, 130 + x, 56, 70, 0, 180); //top part of mouse
	    c.setColor (Color.black);
	    c.drawOval (290, 131 + x, 59, 90); //mouse outline
	    c.drawLine (320, 130 + x, 320, 220 + x); //middle line
	    c.drawLine (290, 165 + x, 349, 165 + x); //horizontal line
	    c.drawArc (315, 120 + x, 5, 10, 270, 180); //first wire
	    c.drawArc (315, 110 + x, 5, 10, 160, 160); //second wire
	    c.drawArc (310, 102 + x, 5, 11, 320, 160); //third wire
	    c.setColor (Color.white);
	    c.fillOval (315, 145 + x, 11, 20); //scroller
	    //delay
	    try
	    {
		Thread.sleep (10);
	    }
	    catch (Exception e)
	    {
	    }
	}
	c.setColor (mouse);
	c.fillArc (291, 229, 56, 70, 0, 180);  //top part of mouse
	c.setColor (Color.gray);
	c.fillArc (291, 229, 60, 70, 90, 90); //clicked top part of mouse
	c.setColor (Color.black);
	c.drawArc (291, 229, 56, 70, 0, 180); //clicked top part of mouse outline
	c.setColor (Color.white);
	c.fillOval (315, 245, 11, 20); //scroller
	//delay
	try
	{
	    Thread.sleep (1000);
	}
	catch (Exception e)
	{
	}

	for (int x = 0 ; x < 60 ; x++)
	{
	    c.setColor (background); //erase colour
	    c.fillOval (278, 200 + x, 75, 133); //erase mouse base
	    //face
	    c.setColor (Color.gray);
	    c.fillRect (282, 193, 75, 60); //standard left head
	    c.setColor (Color.yellow);
	    c.fillRect (295, 236, 50, 10); //mouth
	    c.setColor (Color.gray);
	    c.drawLine (295, 241, 345, 241); //middle brace
	    c.drawLine (305, 231, 305, 246); //first vertical brace
	    c.drawLine (315, 231, 315, 246); //second vertical brace
	    c.drawLine (325, 231, 325, 246); //third vertical brace
	    c.drawLine (335, 231, 335, 246); //fourth vertical brace
	    c.setColor (Color.white);
	    c.fillRect (295, 208, 15, 15); //left eye
	    c.fillRect (330, 208, 15, 15); //right eye
	    c.setColor (Color.cyan);
	    c.fillRect (300, 213, 10, 10); //left pupil
	    c.fillRect (330, 213, 10, 10); //left pupil
	    c.setColor (darkMouse);
	    c.fillOval (290, 230 + x, 60, 90);  //mouse base
	    c.setColor (mouse);
	    c.fillArc (291, 229 + x, 56, 70, 0, 180);  //top part of mouse
	    c.setColor (Color.black);
	    c.drawOval (290, 231 + x, 59, 90);  //mouse outline
	    c.drawLine (320, 230 + x, 320, 320 + x);   //middle line
	    c.drawLine (290, 265 + x, 349, 265 + x);   //horizontal line
	    c.drawArc (315, 220 + x, 5, 10, 270, 180);  //first wire
	    c.drawArc (315, 210 + x, 5, 10, 160, 160);  //second wire
	    c.drawArc (310, 202 + x, 5, 11, 320, 160);  //third wire
	    c.setColor (Color.white);
	    c.fillOval (315, 245 + x, 11, 20);  //scroller
	    //delay
	    try
	    {
		Thread.sleep (10);
	    }
	    catch (Exception e)
	    {
	    }
	}
	c.setColor (mouse);
	c.fillArc (291, 289, 56, 70, 0, 180);  //top part of mouse
	c.setColor (Color.gray);
	c.fillArc (291, 289, 60, 70, 90, 90); //clicked top part of mouse
	c.setColor (Color.black);
	c.drawArc (291, 289, 56, 70, 0, 180); //clicked top part of mouse outline
	c.setColor (Color.white);
	c.fillOval (315, 305, 11, 20);  //scroller
	//delay
	try
	{
	    Thread.sleep (1000);
	}
	catch (Exception e)
	{
	}
	for (int x = 0 ; x < 200 ; x++)
	{
	    c.setColor (background); //erase colour
	    c.fillOval (278 - x, 260 + (x + 50), 75, 133); //erase mouse base
	    //robot body
	    c.setColor (Color.red);
	    int armxthird[] = {260, 190, 190, 215, 215, 270};
	    int armythird[] = {260, 350, 420, 420, 350, 285};
	    c.fillPolygon (armxthird, armythird, 6);
	    int armx2third[] = {380, 450, 450, 425, 425, 370};
	    int army2third[] = {260, 350, 420, 420, 350, 285};
	    c.fillPolygon (armx2third, army2third, 6);
	    c.setColor (Color.white);
	    c.fillOval (300, 250, 40, 20); //neck
	    c.fillOval (188, 340, 30, 25); //left elbow
	    c.fillOval (423, 340, 30, 25); //right elbow
	    c.fillOval (375, 260, 15, 40); //right shoulder
	    c.fillOval (250, 260, 15, 40); //left shoulder
	    c.setColor (Color.red);
	    c.fillRect (260, 260, 120, 160); //body
	    c.setColor (Color.white);
	    c.setFont (new Font ("Times New Roman", 1, 17));
	    c.drawString ("R A P T O R S", 270, 325);
	    c.setFont (new Font ("Times New Roman", 1, 70));
	    c.drawString ("8", 303, 390);
	    c.setColor (Color.white);
	    int vNeckx[] = {283, 320, 357, 298, 320, 342};
	    int vNecky[] = {260, 285, 260, 260, 275, 260};
	    c.fillPolygon (vNeckx, vNecky, 6);
	    c.setColor (Color.black);
	    c.drawLine (283, 260, 320, 285);
	    c.drawLine (320, 285, 357, 260);
	    c.drawLine (298, 260, 320, 275);
	    c.drawLine (320, 275, 342, 260);
	    c.setColor (darkMouse);
	    c.fillOval (290 - x, 290 + (x + 50), 60, 90); //mouse base
	    c.setColor (mouse);
	    c.fillArc (291 - x, 289 + (x + 50), 56, 70, 0, 180); //top part of mouse
	    c.setColor (Color.black);
	    c.drawOval (290 - x, 290 + (x + 50), 59, 90); //mouse outline
	    c.drawLine (320 - x, 290 + (x + 50), 320 - x, 380 + (x + 50)); //middle line
	    c.drawLine (290 - x, 325 + (x + 50), 349 - x, 325 + (x + 50)); //horizontal line
	    c.drawArc (315 - x, 280 + (x + 50), 5, 10, 270, 180); //first wire
	    c.drawArc (315 - x, 270 + (x + 50), 5, 10, 160, 160); //second wire
	    c.drawArc (310 - x, 262 + (x + 50), 5, 11, 320, 160); //third wire
	    c.setColor (Color.white);
	    c.fillOval (315 - x, 305 + (x + 50), 11, 20); //scroller
	    //delay
	    try
	    {
		Thread.sleep (20);
	    }
	    catch (Exception e)
	    {
	    }
	}
	pauseProgram ();
    }


    /* This method will control the program flow and dicrect the user to different screens.
    ----------------------------------------------------------
    Local Variables:
    NAME        TYPE        DESCRIPTION
    ----------------------------------------------------------
    box       int (color) creates a color for the boxes around the options
    ----------------------------------------------------------
    The if statements error trap the code so that an error comes up if they don't enter one of the options.
    The while loop allows them to re-enter the continue choice key if they enter one that's not an option*/
    public void mainMenu ()
    {
	Color box = new Color (218, 167, 242);
	while (true)
	{
	    title ();
	    c.setColor (Color.black);
	    c.setFont (new Font ("Times New Roman", 1, 23));
	    c.drawString ("Menu", 287, 100);
	    c.drawLine (287, 105, 347, 105);
	    c.setFont (new Font ("Times New Roman", 0, 18));
	    c.drawString ("Type:", 170, 130);
	    c.setColor (box);
	    c.fillRect (218, 151, 235, 30);
	    c.fillRect (218, 201, 235, 30);
	    c.fillRect (218, 251, 235, 30);
	    c.fillRect (218, 301, 235, 30);
	    c.fillRect (218, 351, 235, 30);
	    c.setColor (Color.black);
	    c.drawString ("a) to customize a new robot", 220, 170);
	    c.drawString ("b) for instructions", 220, 220);
	    c.drawString ("c) to open an existing robot", 220, 270);
	    c.drawString ("d) to access administrator mode", 220, 320);
	    c.drawString ("e) to exit Build-a-Bot", 220, 370);
	    continueChoice = c.getChar ();
	    if (continueChoice == 'a' | continueChoice == 'b' | continueChoice == 'c' | continueChoice == 'd' | continueChoice == 'e')
	    {
		break;
	    }
	    else
	    {
		JOptionPane.showMessageDialog (null, "Please enter 'a', 'b', 'c', 'd', or 'e' only.", "Error", JOptionPane.ERROR_MESSAGE); //error if they don't use the provided options
	    }
	}
    }


    /* This method explains the program to the user.*/
    public void instructions ()
    {
	title ();
	c.setColor (Color.black);
	c.setFont (new Font ("Times New Roman", 1, 23));
	c.drawString ("Instructions", 260, 100);
	c.drawLine (260, 105, 379, 105);
	c.setFont (new Font ("Times New Roman", 0, 18));
	c.drawString ("1. Type 'a' on your keyboard to start customization.", 25, 160);
	c.drawString ("2. Choose your desired features.", 25, 200);
	c.drawString ("3. Watch Build-a-Bot create the robot of your dreams!", 25, 240);
	c.drawString ("4. Use the '<'&'>' keys to navigate between customization pages.", 25, 280);
	c.drawString ("Press 'm' on your keyboard at any time to return to the menu.", 45, 300);
	c.drawString ("5. After creating and saving your robot, return to the menu to", 25, 340);
	c.drawString ("create a new robot, open an old robot, access administrator mode,", 45, 360);
	c.drawString ("or exit the program.", 45, 380);
	pauseProgram ();
    }


    /* This method introduces the user to customization.
    Local Variables:
    NAME        TYPE        DESCRIPTION
    ----------------------------------------------------------
    arry       int     stores values to an arry to draw
    arrx       int     stores values to an arry to draw
    box   int (color) sets a colour for the box to return to the menu
    ----------------------------------------------------------
    The first if statement error traps the code so that an error comes up if they don't enter one of the options.
    The second and third if statement direct the user to a different page of the program.
    The while loop allows them to enter anoter option if they enter one that's not compatible.*/
    public void intro ()
    {
	Color box = new Color (218, 167, 242);
	int arrx[] = {590, 570, 570}; //x values on right arrow head
	int arry[] = {460, 440, 480}; //y valuese on right arrow head
	while (customizeChoice != 'm')
	{
	    title ();
	    c.setFont (new Font ("Times New Roman", 0, 18));
	    c.setColor (box);
	    c.fillRect (460, 5, 170, 40); //return to menu box
	    c.setColor (Color.black);
	    c.drawString ("Press 'm' to return to", 470, 22); //text in box
	    c.drawString ("the menu.", 510, 42); //text in box
	    c.setColor (Color.black);
	    c.setFont (new Font ("Times New Roman", 1, 23));
	    c.drawString ("Welcome to customization!", 190, 100);
	    c.drawLine (190, 105, 456, 105);
	    c.setFont (new Font ("Times New Roman", 0, 18));
	    c.drawString ("Use '<' and '>' to navigate between customization pages.", 115, 160);
	    c.drawString ("Remember, you must choose one attribute from each page in order to complete and", 20, 230);
	    c.drawString ("save your robot.", 265, 260);
	    c.drawString ("Have fun!", 290, 320);
	    c.fillRect (475, 457, 95, 6); //main arrow right line
	    c.fillPolygon (arrx, arry, 3); //draw right arrow head
	    c.setFont (new Font ("Times New Roman", 0, 16));
	    c.drawString ("Robot Body", 475, 482);
	    customizeChoice = c.getChar ();
	    if (customizeChoice != '.' && customizeChoice != 'm')
	    {
		JOptionPane.showMessageDialog (null, "The key you entered is not compatible with this program.", "Error", JOptionPane.ERROR_MESSAGE); //error if they don't use the provided options
	    }
	    else
		break;
	}
	if (customizeChoice == '.')
	{
	    robotBody ();
	}
	else if (customizeChoice == 'm')
	{
	    return;
	}
    }


    /* This method allows the user to pick a body option for their robot.
      ----------------------------------------------------------
      Local Variables:
      NAME        TYPE        DESCRIPTION
      ----------------------------------------------------------
      input       char        gets the user input
      standard1   int (color) creates a colour for the standard bot
      box   int (color) sets a colour for the box to return to the menu
      arry       int     stores values to an arry to draw
      arrx       int     stores values to an arry to draw
      arry2       int     stores values to an arry to draw
      arrx2      int     stores values to an arry to draw an arm
      armx       int     stores values to an arry to draw an arm
      army       int     stores values to an arry to draw an arm
      army2       int     stores values to an arry to draw an arm
      armx2      int     stores values to an arry to draw an arm
      armxsecond int stores values to an arry to draw a second arm
      armysecond int stores values to an arry to draw a second arm
      armx2second int stores values to an arry to draw a second arm
      army2second int stores values to an arry to draw a second arm
      armxthird int stores values to an arry to draw a third arm
      armythird int stores values to an arry to draw a third arm
      armx2third int stores values to an arry to draw a thid arm
      army2third int stores values to an arry to draw a third arm
      suitNeckx int     stores a value to an array to draw a neck
      suitNecky int     stores a value to an array to draw a neck
      bowx      int     stores a value to an array to draw a bow
      bowy      int     stores a value to an array to draw a bow
      ----------------------------------------------------------
    If statements error trap the code so that an error comes up if they don't enter one of the options,
    they also direct the user to a different page of the program, as well as outline the box of the option
    the user chooses.
    The while loop allows them to enter anoter option if they enter one that's not compatible, and the other while loop
    allows the user to return the menu without the program crashing.*/
    private void robotBody ()
    {
	char input = ' ';
	int arrx[] = {590, 570, 570}; //x values on right arrow head
	int arry[] = {460, 440, 480}; //y valuese on right arrow head
	int arrx2[] = {50, 70, 70}; //x values on left arrow head
	int arry2[] = {460, 440, 480}; //y valuese on left arrow head
	int armx[] = {90, 20, 20, 45, 45, 100};
	int army[] = {85, 175, 245, 245, 175, 110};
	int armx2[] = {210, 280, 280, 255, 255, 200};
	int army2[] = {85, 175, 245, 245, 175, 110};
	int armxsecond[] = {260, 190, 190, 215, 215, 270};
	int armysecond[] = {295, 385, 455, 455, 385, 320};
	int armx2second[] = {380, 450, 450, 425, 425, 370};
	int army2second[] = {295, 385, 455, 455, 385, 320};
	int suitNeckx[] = {300, 320, 340};
	int suitNecky[] = {295, 380, 295};
	int bowx[] = {305, 305, 320, 335, 335};
	int bowy[] = {296, 316, 306, 296, 316};
	int armxthird[] = {427, 357, 357, 382, 382, 437};
	int armythird[] = {85, 175, 245, 245, 175, 110};
	int vNeckx[] = {450, 487, 524, 465, 487, 509};
	int vNecky[] = {85, 110, 85, 85, 100, 85};
	Color standard1 = new Color (250, 255, 0);
	title ();
	c.setFont (new Font ("Times New Roman", 0, 18));
	Color box = new Color (218, 167, 242);
	c.setColor (box);
	c.fillRect (460, 5, 170, 40); //return to menu box
	c.setColor (Color.black);
	c.drawString ("Press 'm' to return to", 470, 22); //text in box
	c.drawString ("the menu.", 510, 42); //text in box
	c.setColor (Color.black);
	c.fillRect (475, 457, 95, 6); //main arrow right line
	c.fillPolygon (arrx, arry, 3); //draw right arrow head
	c.setFont (new Font ("Times New Roman", 0, 16));
	c.drawString ("Robot Face", 475, 482);
	c.fillRect (65, 457, 95, 6); //main arrow left line
	c.fillPolygon (arrx2, arry2, 3); //draw left arrow head
	c.setFont (new Font ("Times New Roman", 0, 16));
	c.drawString ("Intro", 75, 482);
	//first left robot
	c.drawString ("Press 1 to select the Standard Body", 35, 60);
	c.setColor (Color.black);
	c.drawRect (10, 70, 283, 180); //outline
	c.setColor (Color.gray);
	c.fillPolygon (armx, army, 6);
	c.fillPolygon (armx2, army2, 6);
	c.setColor (standard1);
	c.fillOval (130, 75, 40, 20); //neck
	c.fillOval (18, 165, 30, 25); //left elbow
	c.fillOval (253, 165, 30, 25); //right elbow
	c.fillOval (205, 85, 15, 40); //right shoulder
	c.fillOval (80, 85, 15, 40); //left shoulder
	c.setColor (Color.black);
	c.fillRect (90, 85, 120, 160); //body
	c.setColor (Color.gray);
	c.fillRect (105, 140, 5, 90); //red left line
	c.fillRect (120, 140, 75, 90); //big stomach box
	c.setColor (Color.cyan);
	c.fillOval (128, 150, 12, 12); //top dot
	c.fillOval (128, 170, 12, 12); //bottom dot
	c.setColor (standard1);
	c.fillRect (128, 190, 12, 30); //box under dots
	c.drawLine (150, 150, 185, 150); //top line
	c.drawLine (150, 160, 185, 160);
	c.drawLine (150, 170, 185, 170);
	c.drawLine (150, 180, 185, 180);
	c.drawLine (150, 190, 185, 190);
	c.drawLine (150, 200, 185, 200);
	c.drawLine (150, 210, 185, 210);
	c.drawLine (150, 220, 185, 220);
	//second middle robot
	c.setColor (Color.black);
	c.drawString ("Press 3 to select the Stylish Body", 215, 270);
	c.setColor (Color.black);
	c.drawRect (180, 280, 283, 180); //outline
	c.setColor (Color.white);
	c.fillPolygon (armxsecond, armysecond, 6);
	c.fillPolygon (armx2second, army2second, 6);
	c.setColor (Color.black);
	c.fillOval (300, 285, 40, 20); //neck
	c.fillOval (188, 375, 30, 25); //left elbow
	c.fillOval (423, 375, 30, 25); //right elbow
	c.fillOval (375, 295, 15, 40); //right shoulder
	c.fillOval (250, 295, 15, 40); //left shoulder
	c.setColor (Color.black);
	c.fillRect (260, 295, 120, 160); //body
	c.setColor (Color.white);
	c.drawRect (260, 295, 120, 160); //suit outline
	c.fillPolygon (suitNeckx, suitNecky, 3);
	c.setColor (Color.white);
	c.fillOval (317, 385, 6, 6); //bottom button
	c.fillOval (317, 400, 6, 6); //bottom button
	c.fillOval (317, 415, 6, 6); //bottom button
	c.setColor (Color.black);
	c.fillPolygon (bowx, bowy, 5);
	//third right robot
	c.setColor (Color.black);
	c.drawString ("Press 2 to select the Sporty Body", 383, 60);
	c.setColor (Color.black);
	c.drawRect (347, 70, 283, 180); //outline
	c.setColor (Color.red);
	c.fillPolygon (armxthird, armythird, 6);
	int armx2third[] = {547, 617, 617, 592, 592, 537};
	int army2third[] = {85, 175, 245, 245, 175, 110};
	c.fillPolygon (armx2third, army2third, 6);
	c.setColor (Color.white);
	c.fillOval (467, 75, 40, 20); //neck
	c.fillOval (355, 165, 30, 25); //left elbow
	c.fillOval (590, 165, 30, 25); //right elbow
	c.fillOval (542, 85, 15, 40); //right shoulder
	c.fillOval (417, 85, 15, 40); //left shoulder
	c.setColor (Color.red);
	c.fillRect (427, 85, 120, 160); //body
	c.setColor (Color.white);
	c.setFont (new Font ("Times New Roman", 1, 17));
	c.drawString ("R A P T O R S", 437, 150);
	c.setFont (new Font ("Times New Roman", 1, 70));
	c.drawString ("8", 470, 215);
	c.setColor (Color.white);
	c.fillPolygon (vNeckx, vNecky, 6);
	c.setColor (Color.black);
	c.drawLine (450, 85, 487, 110);
	c.drawLine (487, 110, 524, 85);
	c.drawLine (465, 85, 487, 100);
	c.drawLine (487, 100, 509, 85);
	//draw yellow outline if the user returns to the page
	if (robotBodyChoice == '1')
	{
	    c.setColor (Color.yellow);
	    c.drawRect (10, 70, 283, 180); //draw yellow outline
	    c.setColor (Color.black);
	    c.drawRect (347, 70, 283, 180); //cover outline
	    c.drawRect (180, 280, 283, 180); //cover outline
	}
	else if (robotBodyChoice == '2')
	{
	    c.setColor (Color.yellow);
	    c.drawRect (347, 70, 283, 180); //outline
	    c.setColor (Color.black);
	    c.drawRect (10, 70, 283, 180); //cover outline
	    c.drawRect (180, 280, 283, 180); //cover outline
	}
	else if (robotBodyChoice == '3')
	{
	    c.setColor (Color.yellow);
	    c.drawRect (180, 280, 283, 180); //outline
	    c.setColor (Color.black);
	    c.drawRect (10, 70, 283, 180); //cover outline
	    c.drawRect (347, 70, 283, 180); //cover outline
	}

	while (customizeChoice != 'm')
	{
	    if (robotFaceChoice == ' ' | robotFaceChoice == '1' | robotFaceChoice == '2' | robotFaceChoice == '3')
		input = c.getChar ();
	    else
		input = robotBodyChoice;
	    if (input == '1')
	    {
		robotBodyChoice = '1';
		c.setColor (Color.yellow);
		c.drawRect (10, 70, 283, 180); //draw yellow outline
		c.setColor (Color.black);
		c.drawRect (347, 70, 283, 180); //cover outline
		c.drawRect (180, 280, 283, 180); //cover outline
	    }
	    else if (input == '2')
	    {
		robotBodyChoice = '2';
		c.setColor (Color.yellow);
		c.drawRect (347, 70, 283, 180); //outline
		c.setColor (Color.black);
		c.drawRect (10, 70, 283, 180); //cover outline
		c.drawRect (180, 280, 283, 180); //cover outline
	    }
	    else if (input == '3')
	    {
		robotBodyChoice = '3';
		c.setColor (Color.yellow);
		c.drawRect (180, 280, 283, 180); //outline
		c.setColor (Color.black);
		c.drawRect (10, 70, 283, 180); //cover outline
		c.drawRect (347, 70, 283, 180); //cover outline
	    }
	    else if (input == '.' || input == ',' || input == 'm')
	    {
		break;
	    }
	}
	while (true)
	{
	    if (input == ',')
	    {
		intro ();
	    }
	    else if (input == '.')
	    {
		robotFace ();
	    }
	    else if (input == 'm')
	    {
		customizeChoice = 'm';
		intro ();
	    }
	    else
	    {
		JOptionPane.showMessageDialog (null, "The key you entered is not compatible with this program.", "Error", JOptionPane.ERROR_MESSAGE); //error if they don't use the provided options
	    }
	    break;
	}
    }


    /* This method allows the user to pick a face option for their robot.
      ----------------------------------------------------------
      Local Variables:
      NAME        TYPE        DESCRIPTION
      ----------------------------------------------------------
      input       char        gets the user input
      box   int (color) sets a colour for the box to return to the menu
      arry       int     stores values to an arry to draw
      arrx       int     stores values to an arry to draw
      arry2       int     stores values to an arry to draw
      arrx2      int     stores values to an arry to draw an arm
      trix      int       stores values to an array to draw the head
      triy      int       stores values to an array to draw the head
      ----------------------------------------------------------
    If statements error trap the code so that an error comes up if they don't enter one of the options,
    they also direct the user to a different page of the program, as well as outline the box of the option
    the user chooses.
    The while loop allows them to enter anoter option if they enter one that's not compatible, and the other while loop
    allows the user to return the menu without the program crashing.*/
    private void robotFace ()
    {
	char input = ' ';
	Color box = new Color (218, 167, 242);
	int arrx[] = {590, 570, 570}; //x values on right arrow head
	int arry[] = {460, 440, 480}; //y valuese on right arrow head
	int arrx2[] = {50, 70, 70}; //x values on left arrow head
	int arry2[] = {460, 440, 480}; //y valuese on left arrow head
	int trix[] = {460, 540, 500}; //x values trianglehead
	int triy[] = {215, 215, 290}; //y triangle head
	title ();
	c.setFont (new Font ("Times New Roman", 0, 18));
	c.setColor (box);
	c.fillRect (460, 5, 170, 40); //return to menu box
	c.setColor (Color.black);
	c.drawString ("Press 'm' to return to", 470, 22); //text in box
	c.drawString ("the menu.", 510, 42); //text in box
	c.setColor (Color.black);
	c.fillRect (475, 457, 95, 6); //main arrow right line
	c.fillPolygon (arrx, arry, 3); //draw right arrow head
	c.setFont (new Font ("Times New Roman", 0, 16));
	c.drawString ("Antennae", 475, 482);
	c.fillRect (65, 457, 95, 6); //main arrow left line
	c.fillPolygon (arrx2, arry2, 3); //draw left arrow head
	c.setFont (new Font ("Times New Roman", 0, 16));
	c.drawString ("Robot Body", 75, 482);
	//first left robot
	c.setColor (Color.black);
	c.drawString ("Press 1 to select", 105, 165);
	c.drawString ("the", 145, 182);
	c.drawString ("Standard Head", 108, 198);
	c.setColor (Color.black);
	c.drawRect (100, 205, 105, 90); //outline
	c.setColor (Color.gray);
	c.fillRect (115, 220, 75, 60); //standard left head
	c.setColor (Color.yellow);
	c.fillRect (128, 263, 50, 10); //mouth
	c.setColor (Color.gray);
	c.drawLine (128, 268, 178, 268); //middle brace
	c.drawLine (138, 258, 138, 273); //first vertical brace
	c.drawLine (148, 258, 148, 273); //second vertical brace
	c.drawLine (158, 258, 158, 273); //third vertical brace
	c.drawLine (168, 258, 168, 273); //fourth vertical brace
	c.setColor (Color.white);
	c.fillRect (128, 235, 15, 15); //left eye
	c.fillRect (163, 235, 15, 15); //right eye
	c.setColor (Color.cyan);
	c.fillRect (133, 240, 10, 10); //left pupil
	c.fillRect (163, 240, 10, 10); //left pupil
	//second middle robot
	c.setColor (Color.black);
	c.drawString ("Press 2 to select", 277, 165);
	c.drawString ("the", 315, 182);
	c.drawString ("Sporty Head", 285, 198);
	c.setColor (Color.black);
	c.drawRect (272, 205, 105, 90); //outline
	c.setColor (Color.red);
	c.fillOval (290, 212, 70, 75); //sporty middle head
	c.setColor (Color.white);
	c.fillArc (310, 250, 30, 23, 180, 180); //mouth
	c.fillOval (310, 235, 10, 10); //left eye
	c.fillOval (330, 235, 10, 10); //left eye
	c.setColor (Color.black);
	c.drawArc (310, 250, 30, 23, 180, 180); //mouth
	c.drawLine (310, 260, 340, 260); //mouth outline
	c.drawOval (310, 235, 10, 10); //left eye
	c.drawOval (330, 235, 10, 10); //left eye
	//third right robot
	c.setColor (Color.black);
	c.drawString ("Press 3 to select", 450, 165);
	c.drawString ("the", 488, 182);
	c.drawString ("Stylish Head", 460, 198);
	c.setColor (Color.black);
	c.drawRect (445, 205, 105, 90); //outline
	c.fillPolygon (trix, triy, 3); //draw triangle head
	c.setColor (Color.white);
	c.fillRect (475, 223, 20, 10); //left glass
	c.fillRect (505, 223, 20, 10); //right glass
	c.drawLine (495, 228, 505, 228); //middle line
	c.drawLine (475, 228, 460, 215); //left string
	c.drawLine (525, 228, 540, 215); //right string
	if (robotFaceChoice == '1')
	{
	    c.setColor (Color.yellow);
	    c.drawRect (100, 205, 105, 90);  //draw yellow outline
	    c.setColor (Color.black);
	    c.drawRect (272, 205, 105, 90); //cover outline
	    c.drawRect (445, 205, 105, 90);  //cover outline
	}
	else if (robotFaceChoice == '2')
	{
	    c.setColor (Color.yellow);
	    c.drawRect (272, 205, 105, 90); //draw yellow outline
	    c.setColor (Color.black);
	    c.drawRect (445, 205, 105, 90);  //cover outline
	    c.drawRect (100, 205, 105, 90);  //cover outline
	}
	else if (robotFaceChoice == '3')
	{
	    c.setColor (Color.yellow);
	    c.drawRect (445, 205, 105, 90);  //draw yellow outline
	    c.setColor (Color.black);
	    c.drawRect (100, 205, 105, 90);  //cover outline
	    c.drawRect (272, 205, 105, 90); //cover outliine
	}
	while (true)
	{
	    input = c.getChar ();
	    if (input == '1')
	    {
		robotFaceChoice = '1';
		c.setColor (Color.yellow);
		c.drawRect (100, 205, 105, 90);  //draw yellow outline
		c.setColor (Color.black);
		c.drawRect (272, 205, 105, 90); //cover outline
		c.drawRect (445, 205, 105, 90);  //cover outline
	    }
	    else if (input == '2')
	    {
		robotFaceChoice = '2';
		c.setColor (Color.yellow);
		c.drawRect (272, 205, 105, 90); //draw yellow outline
		c.setColor (Color.black);
		c.drawRect (445, 205, 105, 90);  //cover outline
		c.drawRect (100, 205, 105, 90);  //cover outline
	    }
	    else if (input == '3')
	    {
		robotFaceChoice = '3';
		c.setColor (Color.yellow);
		c.drawRect (445, 205, 105, 90);  //draw yellow outline
		c.setColor (Color.black);
		c.drawRect (100, 205, 105, 90);  //cover outline
		c.drawRect (272, 205, 105, 90); //cover outliine
	    }
	    else if (input == 'm' || input == '.' || input == ',')
	    {
		break;
	    }
	}
	while (true)
	{
	    if (input == ',')
	    {
		robotBody ();
	    }
	    else if (input == '.')
	    {
		robotAntennae ();
	    }
	    else if (input == 'm')
	    {
		customizeChoice = 'm';
		intro ();
	    }
	    else
	    {
		JOptionPane.showMessageDialog (null, "The key you entered is not compatible with this program.", "Error", JOptionPane.ERROR_MESSAGE); //error if they don't use the provided options
	    }
	    break;
	}
    }


    /* This method allows the user to pick a antennae option for their robot.
	 ----------------------------------------------------------
	 Local Variables:
	 NAME        TYPE        DESCRIPTION
	 ----------------------------------------------------------
	 input       char        gets the user input
	 box   int (color) sets a colour for the box to return to the menu
	 arry       int     stores values to an arry to draw
	 arrx       int     stores values to an arry to draw
	 arry2       int     stores values to an arry to draw
	 arrx2      int     stores values to an arry to draw an arm
	 ----------------------------------------------------------
       If statements error trap the code so that an error comes up if they don't enter one of the options,
       they also direct the user to a different page of the program, as well as outline the box of the option
       the user chooses.
       The while loop allows them to enter anoter option if they enter one that's not compatible, and the other while loop
       allows the user to return the menu without the program crashing.*/
    private void robotAntennae ()
    {
	char input = ' ';
	Color box = new Color (218, 167, 242);
	int arrx[] = {590, 570, 570}; //x values on right arrow head
	int arry[] = {460, 440, 480}; //y valuese on right arrow head
	int arrx2[] = {50, 70, 70}; //x values on left arrow head
	int arry2[] = {460, 440, 480}; //y valuese on left arrow head
	title ();
	c.setFont (new Font ("Times New Roman", 0, 18));
	c.setColor (box);
	c.fillRect (460, 5, 170, 40); //return to menu box
	c.setColor (Color.black);
	c.drawString ("Press 'm' to return to", 470, 22); //text in box
	c.drawString ("the menu.", 510, 42); //text in box
	c.setColor (Color.black);
	c.fillRect (475, 457, 95, 6); //main arrow right line
	c.fillPolygon (arrx, arry, 3); //draw right arrow head
	c.setFont (new Font ("Times New Roman", 0, 16));
	c.drawString ("Finished!", 475, 482);
	c.fillRect (65, 457, 95, 6); //main arrow left line
	c.fillPolygon (arrx2, arry2, 3); //draw left arrow head
	c.setFont (new Font ("Times New Roman", 0, 16));
	c.drawString ("Robot Face", 75, 482);
	//first left robot
	c.setColor (Color.black);
	c.drawString ("Press 1 to select", 105, 165);
	c.drawString ("the", 145, 182);
	c.drawString ("Standard Antennae", 96, 198);
	c.setColor (Color.black);
	c.drawRect (100, 205, 105, 90); //outline
	c.setColor (Color.black);
	c.drawLine (153, 280, 190, 230); //right antennae
	c.drawLine (153, 280, 116, 230); //left antennae
	c.setColor (Color.cyan);
	c.fillOval (188, 222, 10, 10); //right dot
	c.setColor (Color.yellow);
	c.fillOval (110, 222, 10, 10); //left dot
	c.setColor (Color.black);
	c.drawOval (188, 222, 10, 10); //right dot outline
	c.drawOval (110, 222, 10, 10); //left dot outline
	//second middle robot
	c.setColor (Color.black);
	c.drawString ("Press 2 to select", 277, 165);
	c.drawString ("the", 315, 182);
	c.drawString ("Sporty Antennae", 273, 198);
	c.setColor (Color.black);
	c.drawRect (272, 205, 105, 90); //outline
	c.setColor (Color.black);
	c.drawArc (308, 270, 25, 15, 270, 180); //bottom bounce
	c.drawArc (308, 263, 25, 15, 270, 180);
	c.drawArc (308, 256, 25, 15, 270, 180);
	c.drawArc (308, 249, 25, 15, 270, 180);
	c.drawArc (308, 242, 25, 15, 270, 180);
	c.drawArc (308, 235, 25, 15, 270, 180);
	c.drawArc (308, 228, 25, 15, 270, 180); //top bounce
	c.drawArc (315, 271, 10, 7, 90, 180); //bottom bouce left connector
	c.drawArc (315, 264, 10, 7, 90, 180);
	c.drawArc (315, 257, 10, 7, 90, 180);
	c.drawArc (315, 250, 10, 7, 90, 180);
	c.drawArc (315, 243, 10, 7, 90, 180);
	c.drawArc (315, 236, 10, 7, 90, 180); //top bounce left connector
	c.setColor (Color.red);
	c.fillOval (313, 213, 20, 20); //top ball
	c.setColor (Color.black);
	c.drawOval (313, 213, 19, 20); //top ball outline
	//third right robot
	c.setColor (Color.black);
	c.drawString ("Press 3 to select", 450, 165);
	c.drawString ("the", 488, 182);
	c.drawString ("Stylish Antennae", 448, 198);
	c.setColor (Color.black);
	c.drawRect (445, 205, 105, 90); //outline
	c.setColor (Color.black);
	c.drawLine (490, 280, 490, 225); //left base line
	c.drawLine (490, 225, 460, 225);
	c.drawLine (460, 225, 460, 250);
	c.drawLine (460, 250, 483, 250);
	c.drawLine (483, 250, 483, 232);
	c.drawLine (483, 232, 467, 232);
	c.drawLine (467, 232, 467, 243);
	c.drawLine (467, 243, 478, 243);
	c.drawLine (478, 243, 478, 240);
	c.drawLine (506, 280, 506, 225); //right base line
	c.drawLine (506, 225, 536, 225);
	c.drawLine (536, 225, 536, 250);
	c.drawLine (536, 250, 514, 250);
	c.drawLine (514, 250, 514, 232);
	c.drawLine (514, 232, 530, 232);
	c.drawLine (530, 232, 530, 243);
	c.drawLine (530, 243, 519, 243);
	c.drawLine (519, 243, 519, 240);
	if (robotAntennaeChoice == '1')
	{
	    c.setColor (Color.yellow);
	    c.drawRect (100, 205, 105, 90);  //draw yellow outline
	    c.setColor (Color.black);
	    c.drawRect (272, 205, 105, 90); //cover outline
	    c.drawRect (445, 205, 105, 90);  //cover outline
	}
	else if (robotAntennaeChoice == '2')
	{
	    c.setColor (Color.yellow);
	    c.drawRect (272, 205, 105, 90); //draw yellow outline
	    c.setColor (Color.black);
	    c.drawRect (445, 205, 105, 90);  //cover outline
	    c.drawRect (100, 205, 105, 90);  //cover outline
	}
	else if (robotAntennaeChoice == '3')
	{
	    c.setColor (Color.yellow);
	    c.drawRect (445, 205, 105, 90);  //draw yellow outline
	    c.setColor (Color.black);
	    c.drawRect (100, 205, 105, 90);  //cover outline
	    c.drawRect (272, 205, 105, 90); //cover outliine
	}
	while (true)
	{
	    input = c.getChar ();
	    if (input == '1')
	    {
		robotAntennaeChoice = '1';
		c.setColor (Color.yellow);
		c.drawRect (100, 205, 105, 90);  //draw yellow outline
		c.setColor (Color.black);
		c.drawRect (272, 205, 105, 90); //cover outline
		c.drawRect (445, 205, 105, 90);  //cover outline
	    }
	    else if (input == '2')
	    {
		robotAntennaeChoice = '2';
		c.setColor (Color.yellow);
		c.drawRect (272, 205, 105, 90); //draw yellow outline
		c.setColor (Color.black);
		c.drawRect (445, 205, 105, 90);  //cover outline
		c.drawRect (100, 205, 105, 90);  //cover outline
	    }
	    else if (input == '3')
	    {
		robotAntennaeChoice = '3';
		c.setColor (Color.yellow);
		c.drawRect (445, 205, 105, 90);  //draw yellow outline
		c.setColor (Color.black);
		c.drawRect (100, 205, 105, 90);  //cover outline
		c.drawRect (272, 205, 105, 90); //cover outliine
	    }
	    else if (input == 'm' || input == '.' || input == ',')
	    {
		break;
	    }
	}
	while (true)
	{
	    if (input == ',')
	    {
		robotFace ();
	    }
	    else if (input == '.' && robotBodyChoice != ' ' && robotFaceChoice != ' ' && robotAntennaeChoice != ' ')
	    {
		display ();
	    }
	    else if (input == '.' && (robotBodyChoice == ' ' | robotFaceChoice == ' ' | robotAntennaeChoice == ' '))
	    {
		JOptionPane.showMessageDialog (null, "You must choose a body choice, face choice, and antennae choice before finishing!", "Error", JOptionPane.ERROR_MESSAGE); //error if they don't use the provided options
		robotAntennae ();
	    }
	    else if (input == 'm')
	    {
		customizeChoice = 'm';
		intro ();
	    }
	    else
	    {
		JOptionPane.showMessageDialog (null, "The key you entered is not compatible with this program.", "Error", JOptionPane.ERROR_MESSAGE); //error if they don't use the provided options
	    }
	    break;
	}
    }


    /* This method calculates a decription of a robot for the user.
	 ----------------------------------------------------------
       If statements create a robot description for the user. They create sets. For example,
       if all 3 choices are from the same catergory, it will display 'great match', if they
       are from 2 categories, it will display 'cool mix', and if they are all different, it
       will display 'totally robo-rrific'.*/
    private String calculate (char robotBodyChoice, char robotFaceChoice, char robotAntennaeChoice)
    {
	if (robotBodyChoice == '1') //if the user chose face 1
	{
	    if (robotFaceChoice == '1')
	    {
		if (robotAntennaeChoice == '1')
		{
		    finalRobot = ("Great match! You made a standard robot:");
		}
		else if (robotAntennaeChoice == '2')
		{
		    finalRobot = ("Cool mix! You made a standard and sporty robot:");
		}
		else if (robotAntennaeChoice == '3')
		{
		    finalRobot = ("Cool mix! You made a standard and stylish robot:");
		}
	    }
	    else if (robotFaceChoice == '2')
	    {
		if (robotAntennaeChoice == '1')
		{
		    finalRobot = ("Cool mix! You made a standard and sporty robot:");
		}
		else if (robotAntennaeChoice == '2')
		{
		    finalRobot = ("Cool mix! You made a standard and sporty robot:");
		}
		else if (robotAntennaeChoice == '3')
		{
		    finalRobot = ("Totally robo-rrific! You made a standard, sporty, and stylish robot:");
		}
	    }
	    else if (robotFaceChoice == '3')
	    {
		if (robotAntennaeChoice == '1')
		{
		    finalRobot = ("Cool mix! You made a standard and stylish robot:");
		}
		else if (robotAntennaeChoice == '2')
		{
		    finalRobot = ("Totally robo-rrific! You made a standard, sporty, and stylish robot:");
		}
		else if (robotAntennaeChoice == '3')
		{
		    finalRobot = ("Cool mix! You made a standard and stylish robot:");
		}
	    }
	}
	if (robotBodyChoice == '2') //if the user chose face 2
	{
	    if (robotFaceChoice == '1')
	    {
		if (robotAntennaeChoice == '1')
		{
		    finalRobot = ("Cool mix! You made a standard and sporty robot:");
		}
		else if (robotAntennaeChoice == '2')
		{
		    finalRobot = ("Cool mix! You made a standard and sporty robot:");
		}
		else if (robotAntennaeChoice == '3')
		{
		    finalRobot = ("Totally robo-rrific! You made a standard, sporty, and stylish robot:");
		}
	    }
	    else if (robotFaceChoice == '2')
	    {
		if (robotAntennaeChoice == '1')
		{
		    finalRobot = ("Cool mix! You made a standard and sporty robot:");
		}
		else if (robotAntennaeChoice == '2')
		{
		    finalRobot = ("Great match! You made a sporty robot:");
		}
		else if (robotAntennaeChoice == '3')
		{
		    finalRobot = ("Cool mix! You made a sporty and stylish robot:");
		}
	    }
	    else if (robotFaceChoice == '3')
	    {
		if (robotAntennaeChoice == '1')
		{
		    finalRobot = ("Totally robo-rrific! You made a standard, sporty, and stylish robot:");
		}
		else if (robotAntennaeChoice == '2')
		{
		    finalRobot = ("Cool mix! You made a sporty and stylish robot:");
		}
		else if (robotAntennaeChoice == '3')
		{
		    finalRobot = ("Cool mix! You made a sporty and stylish robot:");
		}
	    }
	}
	if (robotBodyChoice == '3') //if the user chose face 3
	{
	    if (robotFaceChoice == '1')
	    {
		if (robotAntennaeChoice == '1')
		{
		    finalRobot = ("Cool mix! You made a standard and stylish robot:");
		}
		else if (robotAntennaeChoice == '2')
		{
		    finalRobot = ("Totally robo-rrific! You made a standard, sporty, and stylish robot:");
		}
		else if (robotAntennaeChoice == '3')
		{
		    finalRobot = ("Cool mix! You made a standard and stylish robot:");
		}
	    }
	    else if (robotFaceChoice == '2')
	    {
		if (robotAntennaeChoice == '1')
		{
		    finalRobot = ("Totally robo-rrific! You made a standard, sporty, and stylish robot:");
		}
		else if (robotAntennaeChoice == '2')
		{
		    finalRobot = ("Cool mix! You made a sporty and stylish robot:");
		}
		else if (robotAntennaeChoice == '3')
		{
		    finalRobot = ("Cool mix! You made a sporty and stylish robot:");
		}
	    }
	    else if (robotFaceChoice == '3')
	    {
		if (robotAntennaeChoice == '1')
		{
		    finalRobot = ("Cool mix! You made a standard and stylish robot:");
		}
		else if (robotAntennaeChoice == '2')
		{
		    finalRobot = ("Cool mix! You made a sporty and stylish robot:");
		}
		else if (robotAntennaeChoice == '3')
		{
		    finalRobot = ("Great match! You made a stylish robot:");
		}
	    }
	}
	return finalRobot;
    }


    /* This method shows the user their robot.
	 ----------------------------------------------------------
	 Local Variables:
	 NAME        TYPE        DESCRIPTION
	 ----------------------------------------------------------
	 input       char        gets the user input
	 box   int (color) sets a colour for the box to return to the menu
	 army       int     stores values to an arry to draw
	 armx       int     stores values to an arry to draw
	 army2       int     stores values to an arry to draw
	 armx2      int     stores values to an arry to draw an arm
	 outputData  PrintWrtier     writes to a file
	 armysecond       int     stores values to an arry to draw
	 armxsecond       int     stores values to an arry to draw
	 army2second       int     stores values to an arry to draw
	 armx2second      int     stores values to an arry to draw an arm
	  armythird       int     stores values to an arry to draw
	 armxthird       int     stores values to an arry to draw
	 army2third       int     stores values to an arry to draw
	 armx2third      int     stores values to an arry to draw an arm
      trix      int     stores values to an arry to draw a head
     triy      int     stores values to an arry to draw a head
      suitNecky      int     stores values to an arry to draw an neck
       suitNeckx      int     stores values to an arry to draw an neck
       bowy      int     stores values to an arry to draw an bow
       bowx      int     stores values to an arry to draw an bow
	 ----------------------------------------------------------
       If statements error trap the code so that an error comes up if they don't enter one of the options,
       they also direct the user to a different page of the program, as well as displays a robot based on the users
       choices.
       The while loop allows them to enter anoter option if they enter one that's not compatible, and the other while loop
       allows the user to return the menu without the program crashing.*/
    private void display ()
    {
	PrintWriter outputData;
	Color box = new Color (218, 167, 242);
	int armx[] = {260, 190, 190, 215, 215, 270};
	int army[] = {200, 290, 360, 360, 290, 225};
	int armx2[] = {380, 450, 450, 425, 425, 370};
	int army2[] = {200, 290, 360, 360, 290, 225};
	int armxthird[] = {260, 190, 190, 215, 215, 270};
	int armythird[] = {200, 290, 360, 360, 290, 225};
	int vNeckx[] = {283, 320, 357, 298, 320, 342};
	int vNecky[] = {200, 225, 200, 200, 215, 200};
	int armxsecond[] = {260, 190, 190, 215, 215, 270};
	int armysecond[] = {200, 290, 360, 360, 290, 225};
	int armx2second[] = {380, 450, 450, 425, 425, 370};
	int army2second[] = {200, 290, 360, 360, 290, 225};
	int armx2third[] = {380, 450, 450, 425, 425, 370};
	int army2third[] = {200, 290, 360, 360, 290, 225};
	int trix[] = {280, 360, 320}; //x values trianglehead
	int triy[] = {125, 125, 200}; //y triangle head
	int suitNeckx[] = {300, 320, 340};
	int suitNecky[] = {200, 285, 200};
	int bowx[] = {305, 305, 320, 335, 335};
	int bowy[] = {201, 221, 211, 201, 221};
	title ();
	c.setColor (Color.black);
	c.setFont (new Font ("Times New Roman", 1, 16));
	c.drawString (calculate (robotBodyChoice, robotFaceChoice, robotAntennaeChoice), 1, 60);
	c.drawString ("Give a name to your robot to save it, and then press 'm' to return to the menu.", 1, 400);
	//draw robot body
	if (robotBodyChoice == '1')
	{
	    Color standard1 = new Color (250, 255, 0);
	    c.setColor (Color.gray);
	    c.fillPolygon (armx, army, 6);
	    c.fillPolygon (armx2, army2, 6);
	    c.setColor (standard1);
	    c.fillOval (300, 190, 40, 20); //neck
	    c.fillOval (188, 280, 30, 25); //left elbow
	    c.fillOval (423, 280, 30, 25); //right elbow
	    c.fillOval (375, 200, 15, 40); //right shoulder
	    c.fillOval (250, 200, 15, 40); //left shoulder
	    c.setColor (Color.black);
	    c.fillRect (260, 200, 120, 160); //body
	    c.setColor (Color.gray);
	    c.fillRect (275, 255, 5, 90); //red left line
	    c.fillRect (290, 255, 75, 90); //big stomach box
	    c.setColor (Color.cyan);
	    c.fillOval (298, 265, 12, 12); //top dot
	    c.fillOval (298, 285, 12, 12); //bottom dot
	    c.setColor (standard1);
	    c.fillRect (298, 305, 12, 30); //box under dots
	    c.drawLine (320, 265, 355, 265); //top line
	    c.drawLine (320, 275, 355, 275);
	    c.drawLine (320, 285, 355, 285);
	    c.drawLine (320, 295, 355, 295);
	    c.drawLine (320, 305, 355, 305);
	    c.drawLine (320, 315, 355, 315);
	    c.drawLine (320, 325, 355, 325);
	    c.drawLine (320, 335, 355, 335);
	}
	else if (robotBodyChoice == '2')
	{
	    c.setColor (Color.red);
	    c.fillPolygon (armxthird, armythird, 6);
	    c.fillPolygon (armx2third, army2third, 6);
	    c.setColor (Color.white);
	    c.fillOval (300, 190, 40, 20); //neck
	    c.fillOval (188, 280, 30, 25); //left elbow
	    c.fillOval (423, 280, 30, 25); //right elbow
	    c.fillOval (375, 200, 15, 40); //right shoulder
	    c.fillOval (250, 200, 15, 40); //left shoulder
	    c.setColor (Color.red);
	    c.fillRect (260, 200, 120, 160); //body
	    c.setColor (Color.white);
	    c.setFont (new Font ("Times New Roman", 1, 17));
	    c.drawString ("R A P T O R S", 270, 265);
	    c.setFont (new Font ("Times New Roman", 1, 70));
	    c.drawString ("8", 303, 330);
	    c.setColor (Color.white);
	    c.fillPolygon (vNeckx, vNecky, 6);
	    c.setColor (Color.black);
	    c.drawLine (283, 200, 320, 225);
	    c.drawLine (320, 225, 357, 200);
	    c.drawLine (298, 200, 320, 215);
	    c.drawLine (320, 215, 342, 200);
	}
	else if (robotBodyChoice == '3')
	{
	    c.setColor (Color.white);
	    c.fillPolygon (armxsecond, armysecond, 6);
	    c.fillPolygon (armx2second, army2second, 6);
	    c.setColor (Color.black);
	    c.fillOval (300, 190, 40, 20); //neck
	    c.fillOval (188, 280, 30, 25); //left elbow
	    c.fillOval (423, 280, 30, 25); //right elbow
	    c.fillOval (375, 200, 15, 40); //right shoulder
	    c.fillOval (250, 200, 15, 40); //left shoulder
	    c.setColor (Color.black);
	    c.fillRect (260, 200, 120, 160); //body
	    c.setColor (Color.white);
	    c.drawRect (260, 200, 120, 160); //suit outline
	    c.fillPolygon (suitNeckx, suitNecky, 3);
	    c.setColor (Color.white);
	    c.fillOval (317, 290, 6, 6); //bottom button
	    c.fillOval (317, 305, 6, 6); //bottom button
	    c.fillOval (317, 320, 6, 6); //bottom button
	    c.setColor (Color.black);
	    c.fillPolygon (bowx, bowy, 5);
	}
	//first left robot
	if (robotAntennaeChoice == '1')
	{
	    c.setColor (Color.black);
	    c.drawLine (320, 133, 357, 83); //right antennae
	    c.drawLine (320, 133, 283, 83); //left antennae
	    c.setColor (Color.cyan);
	    c.fillOval (355, 75, 10, 10); //right dot
	    c.setColor (Color.yellow);
	    c.fillOval (277, 75, 10, 10); //left dot
	    c.setColor (Color.black);
	    c.drawOval (355, 75, 10, 10); //right dot outline
	    c.drawOval (277, 75, 10, 10); //left dot outline
	}
	//second middle robot
	else if (robotAntennaeChoice == '2')
	{
	    c.setColor (Color.black);
	    c.drawArc (308, 118, 25, 15, 270, 180); //bottom bounce
	    c.drawArc (308, 111, 25, 15, 270, 180);
	    c.drawArc (308, 104, 25, 15, 270, 180);
	    c.drawArc (308, 97, 25, 15, 270, 180);
	    c.drawArc (308, 90, 25, 15, 270, 180); //top bounce
	    c.drawArc (315, 126, 10, 7, 90, 180); //bottom bouce left connector
	    c.drawArc (315, 119, 10, 7, 90, 180);
	    c.drawArc (315, 112, 10, 7, 90, 180);
	    c.drawArc (315, 105, 10, 7, 90, 180);
	    c.drawArc (315, 98, 10, 7, 90, 180); //top bounce left connector
	    c.setColor (Color.red);
	    c.fillOval (313, 75, 20, 20); //top ball
	    c.setColor (Color.black);
	    c.drawOval (313, 75, 19, 20); //top ball outline
	}
	//third robot
	else if (robotAntennaeChoice == '3')
	{
	    c.setColor (Color.black);
	    c.drawLine (312, 133, 312, 78); //left base line
	    c.drawLine (312, 78, 282, 78);
	    c.drawLine (282, 78, 282, 103);
	    c.drawLine (282, 103, 305, 103);
	    c.drawLine (305, 103, 305, 85);
	    c.drawLine (305, 85, 289, 85);
	    c.drawLine (289, 85, 289, 96);
	    c.drawLine (289, 96, 300, 96);
	    c.drawLine (300, 96, 300, 93);
	    c.drawLine (328, 133, 328, 78); //right base line
	    c.drawLine (328, 78, 358, 78);
	    c.drawLine (358, 78, 358, 103);
	    c.drawLine (358, 103, 336, 103);
	    c.drawLine (336, 103, 336, 85);
	    c.drawLine (336, 85, 352, 85);
	    c.drawLine (352, 85, 352, 96);
	    c.drawLine (352, 96, 341, 96);
	    c.drawLine (341, 96, 341, 93);
	}
	//first left robot
	if (robotFaceChoice == '1')
	{
	    c.setColor (Color.gray);
	    c.fillRect (282, 133, 75, 60); //standard left head
	    c.setColor (Color.yellow);
	    c.fillRect (295, 176, 50, 10); //mouth
	    c.setColor (Color.gray);
	    c.drawLine (295, 181, 345, 181); //middle brace
	    c.drawLine (305, 171, 305, 186); //first vertical brace
	    c.drawLine (315, 171, 315, 186); //second vertical brace
	    c.drawLine (325, 171, 325, 186); //third vertical brace
	    c.drawLine (335, 171, 335, 186); //fourth vertical brace
	    c.setColor (Color.white);
	    c.fillRect (295, 148, 15, 15); //left eye
	    c.fillRect (330, 148, 15, 15); //right eye
	    c.setColor (Color.cyan);
	    c.fillRect (300, 153, 10, 10); //left pupil
	    c.fillRect (330, 153, 10, 10); //left pupil
	}
	//second robot
	else if (robotFaceChoice == '2')
	{
	    c.setColor (Color.red);
	    c.fillOval (285, 120, 70, 75); //sporty middle head
	    c.setColor (Color.white);
	    c.fillArc (305, 158, 30, 23, 180, 180); //mouth
	    c.fillOval (305, 143, 10, 10); //left eye
	    c.fillOval (325, 143, 10, 10); //left eye
	    c.setColor (Color.black);
	    c.drawArc (305, 158, 30, 23, 180, 180); //mouth
	    c.drawLine (305, 168, 335, 168); //mouth outline
	    c.drawOval (305, 143, 10, 10); //left eye
	    c.drawOval (325, 143, 10, 10); //left eye
	}
	//third robot
	else if (robotFaceChoice == '3')
	{
	    c.setColor (Color.black);
	    c.fillPolygon (trix, triy, 3); //draw triangle head
	    c.setColor (Color.white);
	    c.fillRect (295, 133, 20, 10); //left glass
	    c.fillRect (325, 133, 20, 10); //right glass
	    c.drawLine (315, 138, 325, 138); //middle line
	    c.drawLine (295, 138, 280, 125); //left string
	    c.drawLine (345, 138, 360, 125); //right string
	}
	c.setColor (box);
	c.fillRect (0, 410, 640, 80); //puple box
	c.setColor (Color.white);
	c.fillRect (0, 430, 640, 40); //white box
	c.setCursor (23, 1);
	c.setTextBackgroundColor (box); //purple text
	robotName = c.readLine ();
	fileName = robotName + ".botFiles";
	try
	{
	    // establish a stream called outputFile to the file myoutdata.txt
	    outputData = new PrintWriter (new FileWriter (fileName));
	    // write data to the file
	    outputData.println (robotName);
	    outputData.println (robotBodyChoice);
	    outputData.println (robotFaceChoice);
	    outputData.println (robotAntennaeChoice);
	    // close the stream
	    outputData.close ();
	}
	catch (IOException e)
	{
	    System.out.println (e);
	}
	while (true)
	{
	    customizeChoice = c.getChar ();
	    if (customizeChoice == 'm')
	    {
		intro ();
		return;
	    }
	    break;
	}
    }


    /* This method allows the user open an exsisting robot.
	 ----------------------------------------------------------
	 Local Variables:
	 NAME        TYPE        DESCRIPTION
	 ----------------------------------------------------------
	 input       BufferedReader reads from a file
	 inputStr    string         recieves input from the user on the robot name
	 army       int     stores values to an arry to draw
	 armx       int     stores values to an arry to draw
	 army2       int     stores values to an arry to draw
	 armx2      int     stores values to an arry to draw an arm
	 outputData  PrintWrtier     writes to a file
	 armysecond       int     stores values to an arry to draw
	 armxsecond       int     stores values to an arry to draw
	 army2second       int     stores values to an arry to draw
	 armx2second      int     stores values to an arry to draw an arm
	  armythird       int     stores values to an arry to draw
	 armxthird       int     stores values to an arry to draw
	 army2third       int     stores values to an arry to draw
	 armx2third      int     stores values to an arry to draw an arm
      trix      int     stores values to an arry to draw a head
     triy      int     stores values to an arry to draw a head
      suitNecky      int     stores values to an arry to draw an neck
       suitNeckx      int     stores values to an arry to draw an neck
       bowy      int     stores values to an arry to draw an bow
       bowx      int     stores values to an arry to draw an bow
	 ----------------------------------------------------------
       If statements error trap the code so that an error comes up if they don't enter a correct robbot name.
       If the robot does exsist, the if statments direct the code to open the correct files to show the correct robot.
       The while loop allows the code to break at different times.*/
    public void openChoice ()
    {
	BufferedReader input;
	File file;
	String inputStr = " ";
	while (true) //clear screen and display title
	{
	    title ();
	    c.setColour (Color.black);
	    c.setFont (new Font ("Times New Roman", 1, 16));
	    c.drawString ("Enter the name of the robot you would like to see:", 10, 55);
	    c.setCursor (3, 45);
	    c.setTextBackgroundColor (background); //blue text background
	    fileName = c.readLine () + ".botFiles";
	    if (fileName.substring (fileName.length () - 9, fileName.length ()).equals (".botFiles"))
	    {
		try
		{
		    file = new File (fileName);
		    if (file.exists ())
		    {
			input = new BufferedReader (new FileReader (fileName));
			robotName = input.readLine ();
			if (robotName != null)
			{
			    input = new BufferedReader (new FileReader (fileName));
			    robotName = input.readLine ();
			    inputStr = input.readLine ();
			    robotBodyChoice = inputStr.charAt (0);
			    inputStr = input.readLine ();
			    robotFaceChoice = inputStr.charAt (0);
			    inputStr = input.readLine ();
			    robotAntennaeChoice = inputStr.charAt (0);

			    //draw robot body
			    if (robotBodyChoice == '1')
			    {
				Color standard1 = new Color (250, 255, 0);
				c.setColor (Color.gray);
				int armx[] = {260, 190, 190, 215, 215, 270};
				int army[] = {200, 290, 360, 360, 290, 225};
				c.fillPolygon (armx, army, 6);
				int armx2[] = {380, 450, 450, 425, 425, 370};
				int army2[] = {200, 290, 360, 360, 290, 225};
				c.fillPolygon (armx2, army2, 6);
				c.setColor (standard1);
				c.fillOval (300, 190, 40, 20); //neck
				c.fillOval (188, 280, 30, 25); //left elbow
				c.fillOval (423, 280, 30, 25); //right elbow
				c.fillOval (375, 200, 15, 40); //right shoulder
				c.fillOval (250, 200, 15, 40); //left shoulder
				c.setColor (Color.black);
				c.fillRect (260, 200, 120, 160); //body
				c.setColor (Color.gray);
				c.fillRect (275, 255, 5, 90); //red left line
				c.fillRect (290, 255, 75, 90); //big stomach box
				c.setColor (Color.cyan);
				c.fillOval (298, 265, 12, 12); //top dot
				c.fillOval (298, 285, 12, 12); //bottom dot
				c.setColor (standard1);
				c.fillRect (298, 305, 12, 30); //box under dots
				c.drawLine (320, 265, 355, 265); //top line
				c.drawLine (320, 275, 355, 275);
				c.drawLine (320, 285, 355, 285);
				c.drawLine (320, 295, 355, 295);
				c.drawLine (320, 305, 355, 305);
				c.drawLine (320, 315, 355, 315);
				c.drawLine (320, 325, 355, 325);
				c.drawLine (320, 335, 355, 335);
			    }
			    else if (robotBodyChoice == '2')
			    {
				c.setColor (Color.red);
				int armxthird[] = {260, 190, 190, 215, 215, 270};
				int armythird[] = {200, 290, 360, 360, 290, 225};
				c.fillPolygon (armxthird, armythird, 6);
				int armx2third[] = {380, 450, 450, 425, 425, 370};
				int army2third[] = {200, 290, 360, 360, 290, 225};
				c.fillPolygon (armx2third, army2third, 6);
				c.setColor (Color.white);
				c.fillOval (300, 190, 40, 20); //neck
				c.fillOval (188, 280, 30, 25); //left elbow
				c.fillOval (423, 280, 30, 25); //right elbow
				c.fillOval (375, 200, 15, 40); //right shoulder
				c.fillOval (250, 200, 15, 40); //left shoulder
				c.setColor (Color.red);
				c.fillRect (260, 200, 120, 160); //body
				c.setColor (Color.white);
				c.setFont (new Font ("Times New Roman", 1, 17));
				c.drawString ("R A P T O R S", 270, 265);
				c.setFont (new Font ("Times New Roman", 1, 70));
				c.drawString ("8", 303, 330);
				c.setColor (Color.white);
				int vNeckx[] = {283, 320, 357, 298, 320, 342};
				int vNecky[] = {200, 225, 200, 200, 215, 200};
				c.fillPolygon (vNeckx, vNecky, 6);
				c.setColor (Color.black);
				c.drawLine (283, 200, 320, 225);
				c.drawLine (320, 225, 357, 200);
				c.drawLine (298, 200, 320, 215);
				c.drawLine (320, 215, 342, 200);
			    }
			    else if (robotBodyChoice == '3')
			    {
				c.setColor (Color.white);
				int armxsecond[] = {260, 190, 190, 215, 215, 270};
				int armysecond[] = {200, 290, 360, 360, 290, 225};
				c.fillPolygon (armxsecond, armysecond, 6);
				int armx2second[] = {380, 450, 450, 425, 425, 370};
				int army2second[] = {200, 290, 360, 360, 290, 225};
				c.fillPolygon (armx2second, army2second, 6);
				c.setColor (Color.black);
				c.fillOval (300, 190, 40, 20); //neck
				c.fillOval (188, 280, 30, 25); //left elbow
				c.fillOval (423, 280, 30, 25); //right elbow
				c.fillOval (375, 200, 15, 40); //right shoulder
				c.fillOval (250, 200, 15, 40); //left shoulder
				c.setColor (Color.black);
				c.fillRect (260, 200, 120, 160); //body
				c.setColor (Color.white);
				c.drawRect (260, 200, 120, 160); //suit outline
				int suitNeckx[] = {300, 320, 340};
				int suitNecky[] = {200, 285, 200};
				c.fillPolygon (suitNeckx, suitNecky, 3);
				c.setColor (Color.white);
				c.fillOval (317, 290, 6, 6); //bottom button
				c.fillOval (317, 305, 6, 6); //bottom button
				c.fillOval (317, 320, 6, 6); //bottom button
				c.setColor (Color.black);
				int bowx[] = {305, 305, 320, 335, 335};
				int bowy[] = {201, 221, 211, 201, 221};
				c.fillPolygon (bowx, bowy, 5);
			    }
			    //first left robot
			    if (robotAntennaeChoice == '1')
			    {
				c.setColor (Color.black);
				c.drawLine (320, 133, 357, 83); //right antennae
				c.drawLine (320, 133, 283, 83); //left antennae
				c.setColor (Color.cyan);
				c.fillOval (355, 75, 10, 10); //right dot
				c.setColor (Color.yellow);
				c.fillOval (277, 75, 10, 10); //left dot
				c.setColor (Color.black);
				c.drawOval (355, 75, 10, 10); //right dot outline
				c.drawOval (277, 75, 10, 10); //left dot outline
			    }
			    //second middle robot
			    else if (robotAntennaeChoice == '2')
			    {
				c.setColor (Color.black);
				c.drawArc (308, 118, 25, 15, 270, 180); //bottom bounce
				c.drawArc (308, 111, 25, 15, 270, 180);
				c.drawArc (308, 104, 25, 15, 270, 180);
				c.drawArc (308, 97, 25, 15, 270, 180);
				c.drawArc (308, 90, 25, 15, 270, 180); //top bounce
				c.drawArc (315, 126, 10, 7, 90, 180); //bottom bouce left connector
				c.drawArc (315, 119, 10, 7, 90, 180);
				c.drawArc (315, 112, 10, 7, 90, 180);
				c.drawArc (315, 105, 10, 7, 90, 180);
				c.drawArc (315, 98, 10, 7, 90, 180); //top bounce left connector
				c.setColor (Color.red);
				c.fillOval (313, 75, 20, 20); //top ball
				c.setColor (Color.black);
				c.drawOval (313, 75, 19, 20); //top ball outline
			    }
			    //third robot
			    else if (robotAntennaeChoice == '3')
			    {
				c.setColor (Color.black);
				c.drawLine (312, 133, 312, 78); //left base line
				c.drawLine (312, 78, 282, 78);
				c.drawLine (282, 78, 282, 103);
				c.drawLine (282, 103, 305, 103);
				c.drawLine (305, 103, 305, 85);
				c.drawLine (305, 85, 289, 85);
				c.drawLine (289, 85, 289, 96);
				c.drawLine (289, 96, 300, 96);
				c.drawLine (300, 96, 300, 93);
				c.drawLine (328, 133, 328, 78); //right base line
				c.drawLine (328, 78, 358, 78);
				c.drawLine (358, 78, 358, 103);
				c.drawLine (358, 103, 336, 103);
				c.drawLine (336, 103, 336, 85);
				c.drawLine (336, 85, 352, 85);
				c.drawLine (352, 85, 352, 96);
				c.drawLine (352, 96, 341, 96);
				c.drawLine (341, 96, 341, 93);
			    }
			    //first left robot
			    if (robotFaceChoice == '1')
			    {
				c.setColor (Color.gray);
				c.fillRect (282, 133, 75, 60); //standard left head
				c.setColor (Color.yellow);
				c.fillRect (295, 176, 50, 10); //mouth
				c.setColor (Color.gray);
				c.drawLine (295, 181, 345, 181); //middle brace
				c.drawLine (305, 171, 305, 186); //first vertical brace
				c.drawLine (315, 171, 315, 186); //second vertical brace
				c.drawLine (325, 171, 325, 186); //third vertical brace
				c.drawLine (335, 171, 335, 186); //fourth vertical brace
				c.setColor (Color.white);
				c.fillRect (295, 148, 15, 15); //left eye
				c.fillRect (330, 148, 15, 15); //right eye
				c.setColor (Color.cyan);
				c.fillRect (300, 153, 10, 10); //left pupil
				c.fillRect (330, 153, 10, 10); //left pupil
			    }
			    //second robot
			    else if (robotFaceChoice == '2')
			    {
				c.setColor (Color.red);
				c.fillOval (285, 120, 70, 75); //sporty middle head
				c.setColor (Color.white);
				c.fillArc (305, 158, 30, 23, 180, 180); //mouth
				c.fillOval (305, 143, 10, 10); //left eye
				c.fillOval (325, 143, 10, 10); //left eye
				c.setColor (Color.black);
				c.drawArc (305, 158, 30, 23, 180, 180); //mouth
				c.drawLine (305, 168, 335, 168); //mouth outline
				c.drawOval (305, 143, 10, 10); //left eye
				c.drawOval (325, 143, 10, 10); //left eye
			    }
			    //third robot
			    else if (robotFaceChoice == '3')
			    {
				c.setColor (Color.black);
				int trix[] = {280, 360, 320}; //x values trianglehead
				int triy[] = {125, 125, 200}; //y triangle head
				c.fillPolygon (trix, triy, 3); //draw triangle head
				c.setColor (Color.white);
				c.fillRect (295, 133, 20, 10); //left glass
				c.fillRect (325, 133, 20, 10); //right glass
				c.drawLine (315, 138, 325, 138); //middle line
				c.drawLine (295, 138, 280, 125); //left string
				c.drawLine (345, 138, 360, 125); //right string
			    }
			    break;
			}
			else
			{
			    c.drawString ("There is no robot with that name. Try again later.", 160, 400);
			    break;
			}
		    }
		    else if (!(file.exists ()))
		    {
			c.drawString ("There is no robot with that name. Try again later.", 160, 400);
			break; //error if they don't use the provided options
		    }
		}
		catch (IOException e)
		{
		}
	    }
	}
	pauseProgram ();
    }


    /* This method allows the user to access admin mode and delete files.
       The password to admin mode is, "47Characters!".
	 ----------------------------------------------------------
	 Local Variables:
	 NAME        TYPE        DESCRIPTION
	 ----------------------------------------------------------
	 box       int (color) sets a colour for the box where the user types
	 file      file        used to check if a file exsist
	 eraseAll  char        used to decide if they would like to erase a file
	 eraseName String      the name of the file they want to erase
	 output    PrintWriter writes to a file
	 adminPassword String  holds the users guess to the password
	 ----------------------------------------------------------
       If statements error trap the code so that an error comes up if they don't enter one of the options or the correct password,
       they also direct the user to a different page of the program, as well as direct the code to write over a file.
       The while loop allows them to enter anoter option if they enter one that's not compatible, and the other while loop
       allows the user to return the menu without the program crashing.*/
    public void adminMode ()
    {
	Color box = new Color (218, 167, 242);
	File file;
	String eraseName = " ";
	char eraseAll = ' ';
	PrintWriter output;
	title ();
	c.setColor (Color.black);
	c.setFont (new Font ("Times New Roman", 1, 23));
	c.drawString ("Administrator Mode", 220, 100);
	c.drawLine (220, 105, 426, 105);
	c.setFont (new Font ("Times New Roman", 0, 18));
	c.drawString ("In order to access administrator mode, you must enter the correct password:", 40, 170);
	c.setColor (box);
	c.fillRect (0, 200, 640, 100); //puple box
	c.setColor (Color.white);
	c.fillRect (0, 220, 640, 60); //white box
	c.setCursor (13, 1);
	c.setTextBackgroundColor (box); //purple text
	c.setColor (Color.black); //so next text is black
	String adminPassword = c.readString ();
	if (adminPassword.equals ("47Characters!"))
	{
	    while (true)
	    {
		c.setColor (Color.black); //set colour
		c.drawString ("You got it! Would you like to erase a saved robot file? (Y/N) : ", 75, 335);
		c.setTextBackgroundColor (background); //purple text
		eraseAll = c.getChar ();
		c.drawString ("" + eraseAll, 530, 335);
		if (eraseAll == 'Y' | eraseAll == 'y' | eraseAll == 'N' | eraseAll == 'n')
		{
		    break;
		}
		else
		{
		    JOptionPane.showMessageDialog (null, "Please enter 'Y' if you would like to erase a saved file, and 'N' to keep them.", "Error", JOptionPane.ERROR_MESSAGE); //error if they don't use the provided options
		    c.setColor (background);
		    c.drawString ("" + eraseAll, 530, 335);
		}
	    }
	    if (eraseAll == 'Y' | eraseAll == 'y')
	    {
		c.drawString ("Enter the name of the robot you would like to erase: ", 75, 375);
		c.setCursor (19, 58);
		fileName = c.readLine () + ".botFiles";
		if (fileName.substring (fileName.length () - 9, fileName.length ()).equals (".botFiles"))
		{
		    file = new File (fileName);
		    if (file.exists ())
		    {
			try
			{
			    output = new PrintWriter (new FileWriter (fileName));
			    output.close ();
			}
			catch (IOException e)
			{
			}
			c.drawString ("That robot file has been erased.", 205, 425);
		    }
		    else if (!(file.exists ()))
		    {
			JOptionPane.showMessageDialog (null, "There is no robot with that name.", "Error", JOptionPane.ERROR_MESSAGE); //error if they don't use the provided options
		    }
		}
	    }
	    else if (eraseAll == 'N' | eraseAll == 'n')
	    {
		c.drawString ("No saved files have been erased.", 205, 425);
	    }
	}
	else
	{
	    c.drawString ("That password is incorrect. Try again later.", 170, 400);
	}
	pauseProgram ();
    }


    /* This method trasitions the user to exiting the program.
	 ----------------------------------------------------------
	 Local Variables:
	 NAME        TYPE        DESCRIPTION
	 ----------------------------------------------------------
	 pic       BufferedImage gets a picture and inputs it*/
    public void goodBye ()
    {
	title (); //clear screen and display title
	c.setColour (Color.black);
	c.setFont (new Font ("Times New Roman", 1, 16));
	c.drawString ("Thank you for using the Build-a-Bot!", 200, 80);
	c.drawString ("By: Maia Mandel", 262, 105);
	c.drawString ("Come again :)", 277, 130);
	//get image
	try
	{
	    BufferedImage pic = ImageIO.read (new File ("pic.png"));
	    c.drawImage (pic, 170, 140, null);
	}
	catch (IOException e)
	{
	}
	pauseProgram (); //press any key
	c.close ();
    }


    /* This method controls the program flow*/
    public static void main (String[] args)
    {
	CustomRobots c = new CustomRobots ();
	c.splashScreen ();
	while (true)
	{
	    c.mainMenu ();
	    if (c.continueChoice == 'e')
	    {
		break;
	    }
	    else if (c.continueChoice == 'a')
	    {
		c.intro ();
	    }
	    else if (c.continueChoice == 'b')
	    {
		c.instructions ();
	    }
	    else if (c.continueChoice == 'c')
	    {
		c.openChoice ();
	    }
	    else if (c.continueChoice == 'd')
	    {
		c.adminMode ();
	    }
	}
	c.goodBye ();

    } // main method
} // CustomRobots class




