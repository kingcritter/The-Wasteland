from pokedex_class import Pokedex
from pokemon_class import Pokemon

pokedex = Pokedex().return_pokedex()

# you've encountered a rattatta! ta. tata.

this_pokemon = Pokemon().new_from_dex(pokedex[2])
print(this_pokemon.name)