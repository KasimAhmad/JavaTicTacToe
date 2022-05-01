
/**
 * Write a description of class Pieces here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pieces extends Player{
    //Instance variables,fields,attributes
    private final int row;
    private final int col;
    
    public Pieces(char name, int row, int col){
        super(name);
        this.row = row;
        this.col = col;
    }
    
    public int getRow(){
        return row;

    }
    
    public int getCol(){
        return col;
    }
    
    @Override
    public String toString(){
        // Pieces: Player [1,2]
        return "Pieces: Player " + getName() + "[" + getRow() + "," + getCol() + "]";
    }
}
