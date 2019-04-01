import java.util.Random;
/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2019-04-01 22:40
 */
public class StringHashFamily implements HashFamily<String>
{
    private final int [ ] MULTIPLIERS;
    private final Random r = new Random( );
    
    public StringHashFamily( int d )
    {
        MULTIPLIERS = new int [ d ];
        generateNewFunctions( );
    }
    @Override
    public int getNumberOfFunctions( )
    {
        return MULTIPLIERS.length;
    }
    
    @Override
    public void generateNewFunctions( )
    {
        for( int i = 0; i < MULTIPLIERS.length; i++ ) {
            MULTIPLIERS[ i ] = r.nextInt( );
        }
    }
    
    @Override
    public int hash(String x, int which )
    {
        final int multiplier = MULTIPLIERS[ which ];
        int hashVal = 0;

        for( int i = 0; i < x.length( ); i++ ) {
            hashVal = multiplier * hashVal + x.charAt( i );
        }
        
        return hashVal;
    }
}
