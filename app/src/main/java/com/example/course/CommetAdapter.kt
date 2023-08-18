package com.example.course

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.course.core.model.body.Comment
import com.example.course.databinding.PostItemBinding

class CommentAdapter(private var commentList:List<Comment> ): RecyclerView.Adapter<CommentAdapter.ViewHolder>() {
    inner class ViewHolder (val binding : PostItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PostItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return commentList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.usernameText.text = "comment_id : ${commentList[position].id} "
        holder.binding.dateText.text = "post id : ${commentList[position].postId}"
        holder.binding.titleText.text = "comment writer : ${commentList[position].name}"
        holder.binding.postText.text = "body of comment :${commentList[position].body}"

    }
}
