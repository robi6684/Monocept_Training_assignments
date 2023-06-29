const Board = require("./board");
const Player = require("./player");

class Game{
    constructor(players,board,turn,isGameActive){
        this.players = players;
        this.board = board;
        this.turn = turn;
        this.isGameActive = isGameActive;
    }

    static newGame(name1,name2){
        if(typeof name1 != "string")
        throw new Error("Please enter valid name1");
        if(typeof name2 != "string")
        throw new Error("Please enter valid name2");
        const players = [Player.newPlayer(name1,"X"),Player.newPlayer(name2,"O")];
        const board = Board.newBoard();
        let turn = 0;

        return new Game(players,board,turn,true);

    }

    play(cellNo){
        if(!Number.isInteger(cellNo))
        throw new Error("Please Enter valid cell number");

        if(cellNo < 0 || cellNo > 8)
        throw new Error("Please enter correct cell number");

        if(!this.isGameActive)
        throw new Error("Game has ended");

        const isCellMarked = this.board.cells[cellNo].isMarked();

        if(isCellMarked)
        throw new Error("Cell is already marked");

        let currentPlayer = this.players[this.turn%2];
        this.board.cells[cellNo].markCell(currentPlayer.symbol);

        this.board.displayBoard();
        this.turn = this.turn + 1;

        const gameStatus = this.board.analyseResult();
        if(gameStatus == "win"){
            this.isGameActive = false;
           
            console.log(`${currentPlayer.name} with symbol ${currentPlayer.symbol} won Game`);
        }
       
        if(gameStatus == "draw"){
            this.isGameActive = false;
            console.log(`No one won the game! Game Draw`);
        }
        
    }
}

module.exports = Game