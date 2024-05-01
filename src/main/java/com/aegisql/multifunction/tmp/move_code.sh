#!/bin/zsh
find ./ -name '*.java' -exec sed -i '' 's/\.tmp;/;/g' {} +
mv -f *.java ../
