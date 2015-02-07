from pokemon_class import Pokemon

class Pokedex(object):
    def __init__(self):
        self.file = open("pokedex.txt").read()
        self.pokedex = {}
        self.build_pokedex()

    def build_pokedex(self):
        info = {"name":     None,
                "poke_id":  None,
                "type":     None,
                "info":     None }
        self.file = self.file.split("\n")
        poke_id = 1
        for line in self.file:
            if line.strip() == "":
                continue
            key, value = line.split(":")
            key = key.strip()
            value = value.strip()
            info[key] = value
            pokemon = Pokemon().new_from_file(info)
            self.pokedex[poke_id] = pokemon
            poke_id += 1

    def return_pokedex(self):
        return self.pokedex