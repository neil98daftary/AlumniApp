package com.example.tejas.alumniapp;

public class Contact {

        //private variables
        int _id;
        String _name;
        String _batch;
        String _email;

    //string email

        // Empty constructor
        public Contact(){

        }
        // constructor
        public Contact(int id, String name, String _batch, String email){
            this._id = id;
            this._name = name;
            this._batch = _batch;
            this._email = email;
        }

        // constructor
        public Contact(String name, String _batch, String email){
            this._name = name;
            this._batch = _batch;
            this._email = email;
        }
        // getting ID
        public int getID(){
            return this._id;
        }

        // setting id
        public void setID(int id){
            this._id = id;
        }

        // getting name
        public String getName(){
            return this._name;
        }

        // setting name
        public void setName(String name){
            this._name = name;
        }

        // getting batch
        public String getbatch(){
            return this._batch;
        }

        // setting batch
        public void setbatch(String batch){
            this._batch = batch;
        }

        public String getEmail() { return  this._email; }

        public void setEmail(String email) { this._email = email; }

}
