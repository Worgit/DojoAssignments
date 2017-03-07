import re
def get_matching_words(regex):
	words = ["aimlessness", "assassin", "baby", "beekeeper", "belladonna", "cannonball", "crybaby", "denver", "embraceable", "facetious", "flashbulb", "gaslight", "hobgoblin", "iconoclast", "issue", "kebab", "kilo", "laundered", "mattress", "millennia", "natural", "obsessive", "paranoia", "queen", "rabble", "reabsorb", "sacrilegious", "schoolroom", "tabby", "tabloid", "unbearable", "union", "videotape"]
	matches = []
 	for word in words:
 		if re.search(regex,word):
 			matches.append(word)
 	return matches
words = get_matching_words(r"\w*v\w*")
print words
words = get_matching_words(r"\w*ss\w*")
print words
words = get_matching_words(r"\w*e\b")
print words
words = get_matching_words(r"\w*b.b\w*")
print words
words = get_matching_words(r"\w*b[^b]+b\w*")
print words
words = get_matching_words(r"\w*b[^b]*b\w*")
print words
##test with aterihoku
words = get_matching_words(r"\w*a[^ e]*e[^ i]*i[^ o]+o[^ u]+u\w*")
print words
words = get_matching_words(r"\b[regularxpsion]+\b")
print words
words = get_matching_words(r"\w*(\w)\1\w*")
print words