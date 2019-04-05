package control;

import com.sun.tools.javac.util.ArrayUtils;
import control.Constants.Const;
import model.Position;
import model.gameObject.GameObject;
import model.gameObject.Hero;
import model.gameObject.Character;
import model.map.Dungeon;
import model.map.Tile;

public class MovementController
{

    private static Dungeon dungeon = GameController.getDungeon();

    //VORLAEUFIG
    private static Position currentPosition = GameController.getHero1().getPosition();

   
    public static void changePositionOfGameObject(Position newPosition)
    {

        if (!MovementVerifier.moveDoesResultInGameObjectLeavingMap(newPosition))
        {
            Tile currentTile = getTileWhichContainsGivenCoordinates(currentPosition);

            Position currentPositionOfTile = calculateRelativePositionForTile(currentPosition);
            
            if (!MovementVerifier.moveResultsInGameObjectLeavingTile(newPosition))
            {
                changePositionOfGameObjectWithinOneTile(currentPositionOfTile, newPosition, currentTile);
            } 
            else
            {
                Tile newTile = getTileWhichContainsGivenCoordinates(newPosition);
                newPosition = calculateRelativePositionForTile(newPosition);
                changePositionOfGameObjectOutsideOneTile(currentPositionOfTile, newPosition, currentTile, newTile);
            }
        }
    }
    

    private static Position calculateRelativePositionForTile(Position position)
    {
        return new Position(position.getX() % Const.TILE_SIZE_X,
                position.getY() % Const.TILE_SIZE_Y);
    }

    private static void changePositionOfGameObjectWithinOneTile(Position currentPosition, Position newPosition, Tile tile)
    {
        GameObject gameObject = tile.getField(currentPosition).getGameObject();
        tile.getField(currentPosition).setGameObject(null);
        tile.getField(newPosition).setGameObject(gameObject);
    }

    private static void changePositionOfGameObjectOutsideOneTile(Position currentPosition, Position newPosition,
                                                                 Tile currentTile, Tile newTile)
    {
        GameObject gameObject = currentTile.getField(currentPosition).getGameObject();
        currentTile.getField(currentPosition).setGameObject(null);
        newTile.getField(newPosition).setGameObject(gameObject);
    }

    private static Tile getTileWhichContainsGivenCoordinates(Position position)
    {
        int xCoordinate = (position.getX() / Const.TILE_SIZE_X);
        int yCoordinate = (position.getY() / Const.TILE_SIZE_Y);
        return dungeon.getTile(new Position(xCoordinate, yCoordinate));
    }
    
    
    //TODO
    public Position[] pathfinder(Position currentPosition, Position endPosition, Character c)
    {
        Position[] range = null;
        Position[] rangex = null;
        Position[] rangey = null;
        Position[] ranged = null;
        //Position ipose = new Position(currentPosition.getX(),currentPosition.getY());
        
        for (int i=0; i < c.getAgility(); i++)
        {
            rangex[i] = new Position(currentPosition.getX()+i, currentPosition.getY()  );
            rangey[i] = new Position(currentPosition.getX()  , currentPosition.getY()+i);
            ranged[i] = new Position(currentPosition.getX()+i, currentPosition.getY()+i);
            //path[i] = new Position(currentPosition.getX()+i, currentPosition.getY()+i);
        }
        for (int i=0; i < c.getAgility(); i++)
        {
            range =  combine(rangex, rangey, ranged);
        }
        return range;
    }
    
    public static Position[] combine(Position[] a, Position[] b, Position[] c)
    {
        int length = a.length + b.length + c.length;
        Position[] result = new Position[length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        System.arraycopy(c, 0, result, a.length + b.length, c.length);
        return result;
    }
}
