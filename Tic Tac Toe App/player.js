class Player{
    constructor(name,symbol){
        this.name = name;
        this.symbol = symbol;
    }

    static newPlayer(name,symbol){
        if(typeof name != "string")
        throw new Error("Please enter valid name");

        if(typeof symbol != "string")
        throw new Error("Please enter valid symbol");

        return new Player(name,symbol);
    }

}

module.exports = Player