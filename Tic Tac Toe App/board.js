const Cell = require("./cell");

class Board{
    constructor(cells){
        this.cells = cells;
    }

    static newBoard(){
        const cells = [];
        for (let index = 0; index < 9; index++) {
            cells[index] = Cell.newCell();
        }

        return new Board(cells);
    }

    displayBoard(){
        let ind = 0;
        let arr = [];
        for (let index = 0; index < 3; index++) {
            arr[index] = this.cells[ind].mark; 
            ind++;
        }
        console.log(arr);
        arr=[];
        for (let index = 0; index < 3; index++) {
            arr[index] = this.cells[ind].mark; 
            ind++;
        }
        console.log(arr);
        arr=[];
        for (let index = 0; index < 3; index++) {
            arr[index] = this.cells[ind].mark; 
            ind++;
        }
        console.log(arr);
        console.log("-----------------")
        arr=[];
    }

    analyseResult(){
        if(this.cells[0].mark == "X" && this.cells[1].mark  == "X" 
        && this.cells[2].mark  == "X")
        return "win";
        if(this.cells[3].mark == "X" && this.cells[4].mark  == "X" 
        && this.cells[5].mark  == "X")
        return "win";
        if(this.cells[6].mark == "X" && this.cells[7].mark  == "X" 
        && this.cells[8].mark  == "X")
        return "win";

        if(this.cells[0].mark == "O" && this.cells[1].mark  == "O" 
        && this.cells[2].mark  == "O")
        return "win";
        if(this.cells[3].mark == "O" && this.cells[4].mark  == "O" 
        && this.cells[5].mark  == "O")
        return "win";
        if(this.cells[6].mark == "O" && this.cells[7].mark  == "O" 
        && this.cells[8].mark  == "O")
        return "win";

        if(this.cells[0].mark == "X" && this.cells[3].mark  == "X" 
        && this.cells[6].mark  == "X")
        return "win";
        if(this.cells[1].mark == "X" && this.cells[4].mark  == "X" 
        && this.cells[7].mark  == "X")
        return "win";
        if(this.cells[2].mark == "X" && this.cells[5].mark  == "X" 
        && this.cells[8].mark  == "X")
        return "win";

        if(this.cells[0].mark == "O" && this.cells[3].mark  == "O" 
        && this.cells[6].mark  == "O")
        return "win";
        if(this.cells[1].mark == "O" && this.cells[4].mark  == "O" 
        && this.cells[7].mark  == "O")
        return "win";
        if(this.cells[2].mark == "O" && this.cells[5].mark  == "O" 
        && this.cells[8].mark  == "O")
        return "win";

        if(this.cells[0].mark == "X" && this.cells[4].mark  == "X" 
        && this.cells[8].mark  == "X")
        return "win";
        if(this.cells[2].mark == "X" && this.cells[4].mark  == "X" 
        && this.cells[6].mark  == "X")
        return "win";

        if(this.cells[0].mark == "O" && this.cells[4].mark  == "O" 
        && this.cells[8].mark  == "O")
        return "win";
        if(this.cells[2].mark == "O" && this.cells[4].mark  == "O" 
        && this.cells[6].mark  == "O")
        return "win";

        for(let i=0; i<9; i++){
            if(this.cells[i].mark == "-")
            return "progress";
        }
        return "draw";
    }
}

module.exports = Board;