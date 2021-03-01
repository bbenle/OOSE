/********************************************************
* PURPOSE: This class is the main which runs the program
*          
* DATE: 26 May 2020
*********************************************************/

package src.controller;

import src.view.UserInterface;

public class CombatGame
{
    public static void main(String[] args)
    {
        UserInterface ui = new UserInterface();
        ui.gameMenu();
    }
} 