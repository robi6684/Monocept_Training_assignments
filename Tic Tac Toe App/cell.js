class Cell{
    constructor(mark){
        this.mark = mark;
    }

    static newCell(){
        return new Cell("-");
    }

    isMarked(){
        return this.mark != "-";
    }

    markCell(mark){
        this.mark = mark;
    }
}

module.exports = Cell;