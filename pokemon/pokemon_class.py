class Pokemon(object):
    def __init__(self):
        self.name = None
        self.id   = None
        self.type = None
        self.info = None
    
    def new_from_dex(self, pokemon):
        self.name = pokemon.name
        self.id   = pokemon.name
        self.type = pokemon.name
        self.info = pokemon.name
        return self

    def new_from_file(self, info):
        self.name = info["name"]
        self.id   = info["poke_id"]
        self.type = info["type"]
        self.info = info["info"]
        return self