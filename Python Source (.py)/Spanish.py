#!/usr/bin/env python
# -*- coding: utf-8 -*-
import sys
import string

file = iter(open("/Users/nickgallimore/Desktop/dictionary.txt", 'r', 0))
searching = True
line = file.readline()
userInput = str(raw_input('Por favor, introduzca la palabra que desea traducir en Inglés: ').lower())

while (searching):
	if (string.split(line.lower(), '|', -1)[0] == userInput):
		print string.split(line, '|', -1)[1]
		searching = False
	else:
		line = file.next()