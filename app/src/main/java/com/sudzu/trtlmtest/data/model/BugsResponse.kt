package com.sudzu.trtlmtest.data.model


import com.google.gson.annotations.SerializedName

data class BugsResponse(
    @SerializedName("bugs")
    val bugDetails: List<BugDetail>
)

data class BugDetail(
    @SerializedName("alias")
    val alias: Any?,
    @SerializedName("assigned_to")
    val assignedTo: String,
    @SerializedName("assigned_to_detail")
    val assignedToDetail: AssignedToDetail,
    @SerializedName("blocks")
    val blocks: List<Int>,
    @SerializedName("cc")
    val cc: List<String>,
    @SerializedName("cc_detail")
    val ccDetail: List<CcDetail>,
    @SerializedName("cf_blocking_thunderbird31")
    val cfBlockingThunderbird31: String,
    @SerializedName("cf_crash_signature")
    val cfCrashSignature: String,
    @SerializedName("cf_fx_iteration")
    val cfFxIteration: String,
    @SerializedName("cf_fx_points")
    val cfFxPoints: String,
    @SerializedName("cf_last_resolved")
    val cfLastResolved: Any?,
    @SerializedName("cf_qa_whiteboard")
    val cfQaWhiteboard: String,
    @SerializedName("cf_status_thunderbird31")
    val cfStatusThunderbird31: String,
    @SerializedName("cf_status_thunderbird_60")
    val cfStatusThunderbird60: String,
    @SerializedName("cf_status_thunderbird_61")
    val cfStatusThunderbird61: String,
    @SerializedName("cf_status_thunderbird_84")
    val cfStatusThunderbird84: String,
    @SerializedName("cf_status_thunderbird_85")
    val cfStatusThunderbird85: String,
    @SerializedName("cf_status_thunderbird_86")
    val cfStatusThunderbird86: String,
    @SerializedName("cf_status_thunderbird_esr78")
    val cfStatusThunderbirdEsr78: String,
    @SerializedName("cf_tracking_thunderbird_84")
    val cfTrackingThunderbird84: String,
    @SerializedName("cf_tracking_thunderbird_85")
    val cfTrackingThunderbird85: String,
    @SerializedName("cf_tracking_thunderbird_86")
    val cfTrackingThunderbird86: String,
    @SerializedName("cf_tracking_thunderbird_esr78")
    val cfTrackingThunderbirdEsr78: String,
    @SerializedName("cf_user_story")
    val cfUserStory: String,
    @SerializedName("classification")
    val classification: String,
    @SerializedName("comment_count")
    val commentCount: Int,
    @SerializedName("component")
    val component: String,
    @SerializedName("creation_time")
    val creationTime: String,
    @SerializedName("creator")
    val creator: String,
    @SerializedName("creator_detail")
    val creatorDetail: CreatorDetail,
    @SerializedName("depends_on")
    val dependsOn: List<Int>,
    @SerializedName("dupe_of")
    val dupeOf: Any?,
    @SerializedName("duplicates")
    val duplicates: List<Int>,
    @SerializedName("flags")
    val flags: List<Flag>,
    @SerializedName("groups")
    val groups: List<Any>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_cc_accessible")
    val isCcAccessible: Boolean,
    @SerializedName("is_confirmed")
    val isConfirmed: Boolean,
    @SerializedName("is_creator_accessible")
    val isCreatorAccessible: Boolean,
    @SerializedName("is_open")
    val isOpen: Boolean,
    @SerializedName("keywords")
    val keywords: List<String>,
    @SerializedName("last_change_time")
    val lastChangeTime: String,
    @SerializedName("mentors")
    val mentors: List<Any>,
    @SerializedName("mentors_detail")
    val mentorsDetail: List<Any>,
    @SerializedName("op_sys")
    val opSys: String,
    @SerializedName("platform")
    val platform: String,
    @SerializedName("priority")
    val priority: String,
    @SerializedName("product")
    val product: String,
    @SerializedName("qa_contact")
    val qaContact: String,
    @SerializedName("qa_contact_detail")
    val qaContactDetail: QaContactDetail,
    @SerializedName("regressed_by")
    val regressedBy: List<Any>,
    @SerializedName("regressions")
    val regressions: List<Any>,
    @SerializedName("resolution")
    val resolution: String,
    @SerializedName("see_also")
    val seeAlso: List<String>,
    @SerializedName("severity")
    val severity: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("target_milestone")
    val targetMilestone: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("version")
    val version: String,
    @SerializedName("votes")
    val votes: Int,
    @SerializedName("whiteboard")
    val whiteboard: String
)

data class AssignedToDetail(
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("nick")
    val nick: String,
    @SerializedName("real_name")
    val realName: String
)


data class CcDetail(
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("nick")
    val nick: String,
    @SerializedName("real_name")
    val realName: String
)

data class CreatorDetail(
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("nick")
    val nick: String,
    @SerializedName("real_name")
    val realName: String
)

data class Flag(
    @SerializedName("creation_date")
    val creationDate: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("modification_date")
    val modificationDate: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("setter")
    val setter: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("type_id")
    val typeId: Int
)

data class QaContactDetail(
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("nick")
    val nick: String,
    @SerializedName("real_name")
    val realName: String
)