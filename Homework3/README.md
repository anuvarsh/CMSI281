LameGame v2
=======

The hierarchy used in this game is as seen in the image below, where all classes outlined in black are concrete classes, and all classes outlined in blue are abstract classes.

![alt tag](http://puu.sh/ce8Hx/47e868e2de.png "Lame Game v2 Hierarchy")

The GameObject abstract class contains all of the methods necessary for displacement (setting, getting, and inverting), coordinates (getting, updating), hit points (updating, getting), and checking collisions with game objects that all active game objects would interact with. The GameObjects abstract class also contains an abstract method called getLabel(), which would require a different char returned for each game object in the game. All other game object classes branch off of this class, including player, monster, boss, wall, rock, and tree. Each of these classes @Override the getLabel() method, as well as add more checkCollision methods that are distinct to their own class. Of these classes, monster and boss are also abstract. This is because both monster and boss have subclasses that have at least 1 fundamental difference between each other. 

The creation of separate classes for each game object is important because when creating the GameEngine, it was important to be able to reference each game object separately, and check collisions between each object specifically. The separation of game objects into separate classes also keeps each of the methods (particularly checkCollision()) hidden within the class to prevent making that information available to the public. 

The coordinate and displacement classes have been maintained due to their specific functionality regarding position in coordinate planes and displacement of positions in the coordinate plane.

The name "Lame Game" could not be 100% revised as this game isn't interactive with players besides updating the frame, and so it is still pretty lame. It is, however, better than the Lame Game created in class, and has therefore been awarded a "version 2" title. 

I created 22 unit tests because I wasn't keeping count. 
