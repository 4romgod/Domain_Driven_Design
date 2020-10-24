package com.ddd.entity;

public class Boxer {

    private String id, name;
    private int wins, losses;

    private Boxer(){}

    private Boxer(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.wins = builder.wins;
        this.losses = builder.losses;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    @Override
    public String toString() {
        return "Boxer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", wins=" + wins +
                ", losses=" + losses +
                '}';
    }


    public static class Builder{

        private String id, name;
        private int wins, losses;

        public Builder setId(String id){
            this.id = id;
            return this;
        }

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setWins(int wins){
            this.wins = wins;
            return this;
        }

        public Builder setLosses(int losses){
            this.losses = losses;
            return this;
        }


        public Builder copy(Boxer boxer){
            this.id = boxer.id;
            this.name = boxer.name;
            this.wins = boxer.wins;
            this.losses = boxer.losses;

            return this;
        }

        public Boxer build(){
            return new Boxer(this);
        }

    }       // end innerClass


}       // end class
