package me.saket.telephoto.sample.gallery

import android.os.Parcelable
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
data class MediaAlbum(
  val items: List<MediaItem>
) : Parcelable

sealed interface MediaItem : Parcelable {
  val caption: String
  val placeholderImageUrl: String?

  @Parcelize
  data class Image(
    val fullSizedUrl: String,
    override val placeholderImageUrl: String?,
    override val caption: String,
  ) : MediaItem

  @Parcelize
  data class Asset(
    val assetName: String,
    override val caption: String,
  ) : MediaItem {
    @IgnoredOnParcel override val placeholderImageUrl: String? = null
  }
}
