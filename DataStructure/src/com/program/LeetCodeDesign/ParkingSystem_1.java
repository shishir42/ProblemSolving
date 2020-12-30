//1.
// Tag: Design

package com.program.LeetCodeDesign;

public class ParkingSystem_1 {
    public static void main(String[] args) {
        ParkingSystemSol parkingSystem = new ParkingSystemSol(1, 1, 0);    
        System.out.println(parkingSystem.addCar(1));
        System.out.println(parkingSystem.addCar(2));
        System.out.println(parkingSystem.addCar(3));
        System.out.println(parkingSystem.addCar(1));
    }    
}

class ParkingSystemSol{
    private int big, medium, small;

    public ParkingSystemSol(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }
    
    public boolean addCar(int carType) {
        if((carType == 1 && this.big == 0) ||  (carType == 2 && this.medium == 0) || (carType == 3 && this.small == 0)){
            return false;
        }

        if(carType == 1)
        {
            this.big--;
        }

        if(carType == 2)
        {
            this.medium--;
        }

        if(carType == 3)
        {
            this.small--;
        }
        
        return true;
    }
}

//Design a parking system for a parking lot. 
//The parking lot has three kinds of parking spaces: 
//big, medium, and small, with a fixed number of slots for each size.

//https://leetcode.com/problems/design-parking-system/

// Input
// ["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
// [[1, 1, 0], [1], [2], [3], [1]]
// Output
// [null, true, true, false, false]

// Explanation
// ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
// parkingSystem.addCar(1); // return true because there is 1 available slot for a big car
// parkingSystem.addCar(2); // return true because there is 1 available slot for a medium car
// parkingSystem.addCar(3); // return false because there is no available slot for a small car
// parkingSystem.addCar(1); // return false because there is no available slot for a big car. It is already occupied.

