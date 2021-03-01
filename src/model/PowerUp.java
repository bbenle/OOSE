/***************************************************
* PURPOSE: This class contains the constructors and
* methods for the enchantment PowerUp
*          
* DATE: 26 May 2020
****************************************************/

package src.model;

public class PowerUp extends Enchantment
{    
    // constructor that multiplies the damage by 1.1 and costs 10 gold
    public PowerUp(Item next)
    {
        super(next);
        next.setMin((int)Math.round(next.getMin() * 1.1));
        next.setMax((int)Math.round(next.getMax() * 1.1));
        next.setCost(next.getCost() +10);
        next.setName(next.getName() + " + 1.1x dmg");
    }

    @Override
    public String getName()
    {
        return next.getName();
    }

    @Override
    public int getMin()
    {
        return next.getMin();
    }

    @Override
    public int getMax()
    {
        return next.getMax();
    }

    @Override
    public int getCost()
    {
        return next.getCost();
    }

    @Override
    public void setName(String inName)
    {
        next.setName(inName);  
    }

    @Override
    public void setMin(int inMin)
    {
        next.setMin(inMin); 
    }

    @Override
    public void setMax(int inMax)
    {
        next.setMax(inMax); 
    }

    @Override
    public void setCost(int inCost)
    {
        next.setCost(inCost); 
    } 

    @Override
    public String toString()
    {
        return next.toString();
    }
}