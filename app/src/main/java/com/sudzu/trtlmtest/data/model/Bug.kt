package com.sudzu.trtlmtest.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bugs")
data class Bug(
    @PrimaryKey
    val id: Int,
    val assignedTo: String,
    val classification: String,
    val commentCount: Int,
    val component: String,
    val creationTime: String,
    val creator: String,
    val isCcAccessible: Boolean,
    val isConfirmed: Boolean,
    val isCreatorAccessible: Boolean,
    val isOpen: Boolean,
    val lastChangeTime: String,
    val opSys: String,
    val platform: String,
    val priority: String,
    val product: String,
    val qaContact: String,
    val resolution: String,
    val severity: String,
    val status: String,
    val summary: String,
    val targetMilestone: String,
    val type: String,
    val url: String,
    val version: String,
    val votes: Int,
    val whiteboard: String
) {
    companion object {
        fun fromResponse(bugDetail: BugDetail): Bug {
            return Bug(
                bugDetail.id,
                bugDetail.assignedTo,
                bugDetail.classification,
                bugDetail.commentCount,
                bugDetail.component,
                bugDetail.creationTime,
                bugDetail.creator,
                bugDetail.isCcAccessible,
                bugDetail.isConfirmed,
                bugDetail.isCreatorAccessible,
                bugDetail.isOpen,
                bugDetail.lastChangeTime,
                bugDetail.opSys,
                bugDetail.platform,
                bugDetail.priority,
                bugDetail.product,
                bugDetail.qaContact,
                bugDetail.resolution,
                bugDetail.severity,
                bugDetail.status,
                bugDetail.summary,
                bugDetail.targetMilestone,
                bugDetail.type,
                bugDetail.url,
                bugDetail.version,
                bugDetail.votes,
                bugDetail.whiteboard
            )
        }
    }
}