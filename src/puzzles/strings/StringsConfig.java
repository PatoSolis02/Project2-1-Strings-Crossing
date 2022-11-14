package puzzles.strings;

import puzzles.common.solver.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class StringsConfig implements Configuration {

    private String currString;
    private String endString;

    public StringsConfig(String start, String end){
        this.currString = start;
        this.endString = end;
    }

    public StringsConfig(StringsConfig current, int index, boolean down) {
        this.endString = current.endString;

        char[] ch = current.currString.toCharArray();
        if(down){
            if(ch[index] == 'A') {
                ch[index] = 'Z';
            } else {
                ch[index] = (char) ((int)ch[index] - 1);
            }
        } else {
            if(ch[index] == 'Z'){
                ch[index] = 'A';
            } else {
                ch[index] = (char) ((int)ch[index] + 1);
            }
        }
        this.currString = String.copyValueOf(ch);
    }


    @Override
    public boolean isSolution() {
        return currString.equals(endString);
    }

    @Override
    public Collection<Configuration> getNeighbors() {
        ArrayList<Configuration> successors = new ArrayList<>();
        for(int i = 0; i < currString.length(); i++){
            successors.add(new StringsConfig(this, i, false));
            successors.add(new StringsConfig(this, i, true));
        }
        return successors;
    }

    @Override
    public boolean equals(Object other) {
        boolean equal = false;
        if(other instanceof StringsConfig otherString){
            equal = otherString.currString.equals(currString);
        }
        return equal;
    }

    @Override
    public int hashCode() {
        return currString.hashCode();
    }

    @Override
    public String toString() {
        return currString;
    }
}
