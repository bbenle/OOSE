/***************************************************
* PURPOSE This class is an interface which Weapon,
* Armour and Potion implements
*          
* DATE: 26 May 2020
****************************************************/

package src.model;

public interface Item
{
    public String getName();

    public int getMin();

    public int getMax();

    public int getCost();

    public void setName(String inName);

    public void setMin(int inMin);

    public void setMax(int inMax);

    public void setCost(int inCost);

    public String toString();
}