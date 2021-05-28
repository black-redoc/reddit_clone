package com.josebas.redditclone.adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.josebas.redditclone.R
import com.josebas.redditclone.model.Post
import de.hdodenhof.circleimageview.CircleImageView

class PostsAdapter(private val postsList: List<Post>): RecyclerView.Adapter<PostsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.post_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.render(postsList[position])
    }

    override fun getItemCount(): Int = postsList.size

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val authorTxt: TextView = view.findViewById(R.id.author_txt)
        private val subredditTxt: TextView = view.findViewById(R.id.subreddit_txt)
        private val titleTxt: TextView = view.findViewById(R.id.title_txt)
        private val awardsTxt: TextView = view.findViewById(R.id.award_txt)
        private val descriptionTxt: TextView = view.findViewById(R.id.description_text)
        private val upsTxt: Button = view.findViewById(R.id.ups_txt)
        private val numCommentsTxt: Button = view.findViewById(R.id.num_comments_text)
        private val videoView: VideoView = view.findViewById(R.id.video_view)
        private val thumbnail: CircleImageView = view.findViewById(R.id.thumbnail)
        private val imageUrl: ImageView = view.findViewById(R.id.image_url)

        fun render(post: Post) {
            post.also {
                Glide.with(view).load("${it.thumbnail}").into(thumbnail)
                if (it.is_video) {
                    videoView.setVideoURI(Uri.parse("${it.secure_media.reddit_video}"))
                    videoView.visibility = View.VISIBLE
                }

                if (it.url?.isNotEmpty() == true && !it.is_video) {
                    Glide.with(view).load(it.thumbnail).into(imageUrl)
                    imageUrl.visibility = View.VISIBLE
                }

                authorTxt.text = it.author
                subredditTxt.text = "r/${it.subreddit}"
                titleTxt.text = it.title
                awardsTxt.text = "${it.total_awards_received} Awards"
                descriptionTxt.text = it.description
                numCommentsTxt.text = "${
                    if (it.num_comments.toString().length > 3) "${it.num_comments.div(100)}K"
                    else it.num_comments
                }"
                upsTxt.text = "${
                    if (it.ups.toString().length > 3) "${it.ups?.div(100)}K"
                    else it.ups
                }"
            }

        }
    }
}