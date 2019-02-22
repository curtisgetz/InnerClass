package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by dev on 18/09/15.
 */
public class Album {
    private String name;
    private String artist;
    private SongList mSongList;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.mSongList = new SongList();
    }

    public boolean addSong(String title, double duration){
        return this.mSongList.add(new Song(title, duration));
    }
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
       Song checkedSong = this.mSongList.findSong(trackNumber);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = this.mSongList.findSong(title);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }


    public class SongList {
        private ArrayList<Song> mSongs;

         SongList() {
            this.mSongs = new ArrayList<>();
        }


         boolean add(Song song){
            if(this.mSongs.contains(song)) {
                return false;
            }
            this.mSongs.add(song);
            return true;

        }

         Song findSong(String title){
            for(Song song : this.mSongs){
                if(song.getTitle().equals(title)){
                    return song;
                }
            }
            return null;
        }

         Song findSong(int trackNumber) {
             int listIndex = trackNumber - 1;
            if(listIndex >= 0 && listIndex < this.mSongs.size()){
                return this.mSongs.get(listIndex);
            }
            return null;
        }

    }
















}
