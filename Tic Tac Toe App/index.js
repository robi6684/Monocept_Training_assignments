const Game = require("./game");

try{
const game1 = Game.newGame("Ravi","Akash");
game1.play(0);
game1.play(1);
game1.play(2);
game1.play(4);
game1.play(3);
game1.play(5);
game1.play(7);
game1.play(6);
game1.play(8);

const game2 = Game.newGame("Mukesh","Akash");
game2.play(1);
game2.play(0);
game2.play(2);
game2.play(3);
game2.play(5);
game2.play(6);

}
catch(error){
    console.log(error.message);
}