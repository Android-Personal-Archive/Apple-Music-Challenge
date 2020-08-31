package com.mcs.applemusicchallenge.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mcs.applemusicchallenge.R
import com.mcs.applemusicchallenge.pokos.ResultsPOKO
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.song_item_layout.view.*

class ResultsAdapter(context: Context, private val pokoDataSet: ResultsPOKO): RecyclerView.Adapter<ResultsAdapter.ResultsViewHolder>() {
    class ResultsViewHolder(songItemView: View): RecyclerView.ViewHolder(songItemView){
        val ivArtwork: ImageView = songItemView.iv_artwork
        val tvAlbum: TextView = songItemView.tv_album
        val tvArtist: TextView = songItemView.tv_artist
        val tvPrice: TextView = songItemView.tv_price
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultsViewHolder {
        val siView: View = LayoutInflater.from(parent.context).inflate(R.layout.song_item_layout, parent, false)
        return ResultsViewHolder(siView)
    }

    override fun getItemCount(): Int {
        return pokoDataSet.resultCount
    }

    //wrapperType: "track"
    //kind: "song"
    //artistId: 218563
    //collectionId: 1496427902
    //trackId: 1496428537
    //artistName: "Rock"
    //collectionName: "EA Sports Soundtrax, Vol. 1 (Original Soundtrack)"
    //trackName: "I Am Rock"
    //collectionCensoredName: "EA Sports Soundtrax, Vol. 1 (Original Soundtrack)"
    //trackCensoredName: "I Am Rock"
    //collectionArtistId: 267712132
    //collectionArtistName: "EA Games Soundtrack"
    //collectionArtistViewUrl: "https://music.apple.com/us/artist/ea-games-soundtrack/267712132?uo=4"
    //artistViewUrl: "https://music.apple.com/us/artist/rock/218563?uo=4"
    //collectionViewUrl: "https://music.apple.com/us/album/i-am-rock/1496427902?i=1496428537&uo=4"
    //trackViewUrl: "https://music.apple.com/us/album/i-am-rock/1496427902?i=1496428537&uo=4"
    //previewUrl: "https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview113/v4/4b/cc/7a/4bcc7aba-b087-9197-33d0-f68ed19617d7/..."
    //artworkUrl30: "https://is1-ssl.mzstatic.com/image/thumb/Music113/v4/0b/69/ed/0b69ed0b-0bbb..."
    //artworkUrl60: "https://is1-ssl.mzstatic.com/image/thumb/Music113/v4..."
    //artworkUrl100: "https://is1-ssl.mzastatic.com/image/thumb/Music113/v4/0b/69/ed/..."
    //collectionPrice: 9.99
    //trackPrice: 1.29
    //releaseDate: "2005-09-06T12:00:00Z"
    //collectionExplicitness: "notExplicit"
    //trackExplicitness: "notExplicit"
    //discCount: 1
    //discNumber: 1
    //trackCount: 12
    //trackNumber: 5
    //trackTimeMillis: 230827
    //country: "USA"
    //currency: "USD"
    //primaryGenreName: "Soundtrack"
    //isStreamable: true
    override fun onBindViewHolder(holder: ResultsViewHolder, position: Int) {
        //        val ivArtwork: ImageView = songItemView.iv_artwork
        //        val tvAlbum: TextView = songItemView.tv_album
        //        val tvArtist: TextView = songItemView.tv_artist
        //        val tvPrice: TextView = songItemView.tv_price
        Picasso.get().load(pokoDataSet.results[position].artworkUrl100).into(holder.ivArtwork)
        holder.tvAlbum.text = pokoDataSet.results[position].collectionName
        holder.tvArtist.text = pokoDataSet.results[position].artistName
        holder.tvPrice.text = pokoDataSet.results[position].trackPrice.toString()
    }
}