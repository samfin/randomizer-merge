package com.dabomstew.pkrandom.pokemon;

/*----------------------------------------------------------------------------*/
/*--  Move.java - represents a move usable by Pokemon.                      --*/
/*--                                                                        --*/
/*--  Part of "Universal Pokemon Randomizer" by Dabomstew                   --*/
/*--  Pokemon and any associated names and the like are                     --*/
/*--  trademark and (C) Nintendo 1996-2012.                                 --*/
/*--                                                                        --*/
/*--  The custom code written here is licensed under the terms of the GPL:  --*/
/*--                                                                        --*/
/*--  This program is free software: you can redistribute it and/or modify  --*/
/*--  it under the terms of the GNU General Public License as published by  --*/
/*--  the Free Software Foundation, either version 3 of the License, or     --*/
/*--  (at your option) any later version.                                   --*/
/*--                                                                        --*/
/*--  This program is distributed in the hope that it will be useful,       --*/
/*--  but WITHOUT ANY WARRANTY; without even the implied warranty of        --*/
/*--  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the          --*/
/*--  GNU General Public License for more details.                          --*/
/*--                                                                        --*/
/*--  You should have received a copy of the GNU General Public License     --*/
/*--  along with this program. If not, see <http://www.gnu.org/licenses/>.  --*/
/*----------------------------------------------------------------------------*/

public class Move {

    public String name;
    public int number;
    public int internalId;
    public int power;
    public int pp;
    public double hitratio;
    public Type type;
    public int effectIndex;
    public MoveCategory category;
    public double hitCount = 1; // not saved, only used in randomized move powers.

    public String toString() {
        return "#" + number + " " + name + " - Power: " + power + ", Base PP: " + pp + ", Type: " + type + ", Hit%: "
                + (hitratio) + ", Effect: " + effectIndex;
    }
    
    public boolean isDamaging() {
        // Some moves are bad
        if(number == 138 || number == 13 || number == 19 || number == 76 || number == 80 || number == 120 || 
                number == 139 || number == 143 || number == 153 || number == 91 || number == 248)
            return false;
        
        if(hitratio < 0.69)
            return false;
        
        // Bonemerang is strong enough
        return power >= 75 || number == 155;
    }
    
    public boolean isSpecial() {
        return type.equals(Type.WATER) || type.equals(Type.GRASS) || type.equals(Type.FIRE)
                || type.equals(Type.ELECTRIC) || type.equals(Type.ICE) || type.equals(Type.PSYCHIC)
                || type.equals(Type.DRAGON) || type.equals(Type.DARK);
    }

}
