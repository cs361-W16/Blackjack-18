/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;

import models.Game;
import models.Player;
import ninja.Context;
import ninja.Result;
import ninja.Results;

import com.google.inject.Singleton;
import ninja.params.PathParam;


@Singleton
public class ApplicationController {

    public Result index() {
        return Results.html();
    }

    public Result blackJack() {
        return Results.html().template("views/BlackJack/BlackJack.flt.html");
    }
    
    public Result gameGet(){
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.dealFour();
        g.error = false;

        return Results.json().render(g);
    }

    public Result dealPost(Context context, Game g) {
        if(context.getRequestPath().contains("deal")){
            g.dealFour();
        }
        g.error=false;
        return Results.json().render(g);
    }

    //testing application controller, hit button pushes four cards into the current game
    public Result hitPost(Context context, Game g) {
        g.dealOne();
        g.error=false;
        return Results.json().render(g);
    }


    //function prototypes for application controller
    public Result stayPost(Context context, Game g) {
        return  Results.json().render(g);
    }

    public Result doublePost(Context context, Game g) {
        return  Results.json().render(g);
    }

    public Result splitPost(Context context, Game g) {
        return  Results.json().render(g);
    }

    public Result removeCard(Context context, @PathParam("column") int colNumber, Game g){
        g.remove(colNumber);
        return  Results.json().render(g);
    }

    public Result moveCard(Context context, @PathParam("columnFrom") int colFrom, @PathParam("columnTo") int colTo, Game g){
        g.move(colFrom,colTo);
        g.error=false;
        return  Results.json().render(g);
    }

}
