//U10416035 Cheng Chih Lin

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class BeanGame extends Application{

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		
		
	
		//add the line of the shape
		Polyline line = new Polyline();
		line.getPoints().addAll(155d,40d,155d,60d,70d,195d,70d,230d);
		
		Polyline line2 = new Polyline();
		line2.getPoints().addAll(175d,40d,175d,60d,260d,195d,260d,230d);
		
		Polyline line3 = new Polyline();
		line3.getPoints().addAll(70d,230d,260d,230d);
		
		
		// add the ball of the shape
		Circle c = new Circle(5);
		c.relocate(160d,70d);
		Circle c1 = new Circle(5);
		c1.relocate(148d,90d);
		Circle c2 = new Circle(5);
		c2.relocate(172d,90d);
		Circle c3 = new Circle(5);
		c3.relocate(136d,110d);
		Circle c4 = new Circle(5);
		c4.relocate(160d,110d);
		Circle c5 = new Circle(5);
		c5.relocate(184d,110d);
		Circle c6 = new Circle(5);
		c6.relocate(124d,130d);
		Circle c7 = new Circle(5);
		c7.relocate(148d,130d);
		Circle c8 = new Circle(5);
		c8.relocate(172d,130d);
		Circle c9 = new Circle(5);
		c9.relocate(196d,130d);
		Circle c10 = new Circle(5);
		c10.relocate(112d,150d);
		Circle c11 = new Circle(5);
		c11.relocate(136d,150d);
		Circle c12 = new Circle(5);
		c12.relocate(160d,150d);
		Circle c13 = new Circle(5);
		c13.relocate(184d,150d);

		Circle c14 = new Circle(5);
		c14.relocate(208d,150d);
		Circle c15 = new Circle(5);
		c15.relocate(100d,170d);
		Circle c16 = new Circle(5);
		c16.relocate(124d,170d);
		Circle c17 = new Circle(5);
		c17.relocate(148d,170d);
		Circle c18 = new Circle(5);
		c18.relocate(172d,170d);
		Circle c19 = new Circle(5);
		c19.relocate(196d,170d);
		Circle c20 = new Circle(5);
		c20.relocate(220d,170d);
		Circle c21 = new Circle(5);
		c21.relocate(88d,190d);
		Circle c22 = new Circle(5);
		c22.relocate(112d,190d);
		Circle c23 = new Circle(5);
		c23.relocate(136d,190d);
		Circle c24 = new Circle(5);
		c24.relocate(160d,190d);
		Circle c25 = new Circle(5);
		c25.relocate(184d,190d);
		Circle c26 = new Circle(5);
		c26.relocate(208d,190d);
		Circle c27 = new Circle(5);
		c27.relocate(232d,190d);
		
		
		//add the bottom line of the bean game
		Polyline line4 = new Polyline();
		line4.getPoints().addAll(93d,190d,93d,230d);
		Polyline line5 = new Polyline();
		line5.getPoints().addAll(117d,190d,117d,230d);
		Polyline line6 = new Polyline();
		line6.getPoints().addAll(141d,190d,141d,230d);
		Polyline line7 = new Polyline();
		line7.getPoints().addAll(165d,190d,165d,230d);
		Polyline line8 = new Polyline();
		line8.getPoints().addAll(189d,190d,189d,230d);
		Polyline line9 = new Polyline();
		line9.getPoints().addAll(213d,190d,213d,230d);
		Polyline line10 = new Polyline();
		line10.getPoints().addAll(237d,190d,237d,230d);
		
		//to new a group (children)
		Group g = new Group();
		
		//to add the all line into the shape
		g.getChildren().add(line);
		g.getChildren().add(line2);
		g.getChildren().add(line3);
		g.getChildren().addAll(line4,line5,line6,line7,line8,line9,line10);
		
		//add the circle into the shape
		g.getChildren().addAll(c,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27);
		
		//Create a scene and place it in the stage
		Scene scene = new Scene(g, 330, 250);
		
		//when the user click the scene will run the function
		scene.setOnMouseClicked (e -> {
			
			//decide the rolling ball's seat and radius
			int x =165,y=55;
			int radius =4;
		
			//new a circle object , change it's color and add it to the group
			Circle circle = new Circle(x,y,radius);
			circle.setFill(Color.BLUE);
			g.getChildren().add(circle);
			
			//run the path() method
			pathh(circle,x,y);
		});
		
		primaryStage.setTitle("Beam Game"); // Set title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}	
	
	//this method is the ball's path and decide where it can roll
	public void pathh(Node circle , int x , int y){
		
		//local varaible to define a new variable and change it's value 
		int xx = x ;
		int yy = y;
		//new a peth object
		Path path = new Path();
		
		//give the initial moveto in order to roll the ball
		path.getElements().add(new MoveTo(xx,yy));

		//the for loop let the ball roll 
		for(int i = 1 ; i < 8 ; i++){
			
			int random = (int) (Math.random()*2+1);	
			//new a lineto and moveto to decide it's seat
			LineTo lineto  = new LineTo(xx,yy+=20);
			path.getElements().add(lineto);
			path.getElements().add(new MoveTo(xx,yy));
			
			//use random to decide the ball will go right or left
			if(random == 1){
				
				path.getElements().add(new LineTo(xx+=11.5,yy));
			}
			
			else{
				
				path.getElements().add(new LineTo(xx-=11.5,yy));
			}
		}
		//let the ball go to down
		path.getElements().add(new LineTo(xx, yy+=30));
		
		//use the pathtransition to decide the ball 's duration , path and node and to play the function
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(1000));	
		pt.setPath(path);
		pt.setNode(circle);
    		pt.setAutoReverse(false);
		//Start the animation
		pt.play();		
	}
	
	

  public static void main(String[] args) {
    launch(args);
  }
}
