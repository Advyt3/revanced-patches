package app.revanced.patches.spotify.layout.theme

import app.revanced.patcher.data.ResourceContext
import app.revanced.patcher.patch.ResourcePatch
import app.revanced.patcher.patch.annotation.CompatiblePackage
import app.revanced.patcher.patch.annotation.Patch
import app.revanced.patcher.patch.options.PatchOption.PatchExtensions.stringPatchOption
import org.w3c.dom.Element

@Patch(
    name = "Custom theme",
    description = "Applies a custom theme.",
    compatiblePackages = [CompatiblePackage("com.spotify.music")]
)
@Suppress("unused")
object CustomThemePatch : ResourcePatch() {
    private var backgroundColor by
        stringPatchOption(
            key = "backgroundColor",
            default = "@android:color/black",
            title = "Primary background color",
            description = "The background color. Can be a hex color or a resource reference.",
            required = true
        )

    private var backgroundColorSecondary by
        stringPatchOption(
            key = "backgroundColorSecondary",
            default = "#ff282828",
            title = "Secondary background color",
            description =
                "The secondary background color. This changes Settings header, Search Box background, etc. Can be a hex color or a resource reference.",
            required = true
        )

    private var accentColor by
        stringPatchOption(
            key = "accentColor",
            default = "#ff1ed760",
            title = "Accent color",
            description =
                "The accent color ('Spotify green' by default). Can be a hex color or a resource reference.",
            required = true
        )

    private var accentColorSecondary by
        stringPatchOption(
            key = "accentColorSecondary",
            default = "#ff14833b",
            title = "Secondary Accent color",
            description =
                "The Secondary accent color, a Darker accent color ('Spotify dark green' by default). Can be a hex color or a resource reference.",
            required = true
        )

    private var accentColorPressed by
        stringPatchOption(
            key = "accentColorPressed",
            default = "#ff169c46",
            title = "Pressed dark theme accent color",
            description =
                "The color when accented buttons are pressed, by default slightly darker than accent. " +
                    "Can be a hex color or a resource reference.",
            required = true
        )

    override fun execute(context: ResourceContext) {
        val backgroundColor = backgroundColor!!
        val backgroundColorSecondary = backgroundColorSecondary!!
        val accentColor = accentColor!!
        val accentColorSecondary = accentColorSecondary!!
        val accentColorPressed = accentColorPressed!!

        context.xmlEditor["res/values/colors.xml"].use { editor ->
            val resourcesNode = editor.file.getElementsByTagName("resources").item(0) as Element

            for (i in 0 until resourcesNode.childNodes.length) {
                val node = resourcesNode.childNodes.item(i) as? Element ?: continue

                node.textContent =
                    when (node.getAttribute("name")) {
                        "dark_base_background_elevated_base",
                        "design_dark_default_color_background",
                        "design_dark_default_color_surface",
                        "gray_7",
                        "gray_background",
                        "gray_layer",
                        "sthlm_blk" -> backgroundColor
                        "gray_15" -> backgroundColorSecondary
                        "abc_search_url_text_normal",
                        "accent",
                        "accent_material_dark",
                        "adanalyticslight_base_essential_brightaccent",
                        "adanalyticslight_base_text_positive",
                        "adanalyticslight_brightaccent_background_base",
                        "adanalyticslight_brightaccent_background_highlight",
                        "adanalyticslight_brightaccent_decorative_subdued",
                        "adanalyticslight_inverteddark_essential_brightaccent",
                        "adanalyticslight_inverteddark_text_brightaccent",
                        "adanalyticslight_mutedaccent_essential_brightaccent",
                        "adanalyticslight_mutedaccent_text_brightaccent",
                        "adanalyticslight_positive_background_base",
                        "adanalyticslight_positive_background_highlight",
                        "add_to_playlist_sort_row_active",
                        "advertisingdark_base_essential_positive",
                        "advertisingdark_base_text_positive",
                        "advertisingdark_positive_background_base",
                        "advertisingdark_positive_background_highlight",
                        "advertisingdark_positive_decorative_subdued",
                        "advertisinglight_base_essential_positive",
                        "advertisinglight_positive_background_base",
                        "advertisinglight_positive_background_highlight",
                        "advertisinglight_positive_decorative_subdued",
                        "anchorlight_base_essential_positive",
                        "anchorlight_positive_background_base",
                        "anchorlight_positive_background_highlight",
                        "anchorlight_positive_decorative_subdued",
                        "carColorGreen",
                        "connect_device_green",
                        "creatordark_base_essential_positive",
                        "creatordark_base_text_positive",
                        "creatordark_positive_background_base",
                        "creatordark_positive_background_highlight",
                        "creatordark_positive_decorative_subdued",
                        "creatorlight_base_essential_positive",
                        "creatorlight_base_text_positive",
                        "creatorlight_positive_background_base",
                        "creatorlight_positive_background_highlight",
                        "creatorlight_positive_decorative_subdued",
                        "dark_base_essential_brightaccent",
                        "dark_base_essential_positive",
                        "dark_base_text_brightaccent",
                        "dark_base_text_positive",
                        "dark_brightaccent_background_base",
                        "dark_brightaccent_background_highlight",
                        "dark_brightaccent_decorative_subdued",
                        "dark_inverteddark_essential_brightaccent",
                        "dark_inverteddark_text_brightaccent",
                        "dark_invertedlight_essential_brightaccent",
                        "dark_mutedaccent_essential_brightaccent",
                        "dark_mutedaccent_text_brightaccent",
                        "dark_positive_background_base",
                        "dark_positive_background_highlight",
                        "dark_positive_decorative_subdued",
                        "default_endless_dj_button_icon",
                        "electric_seafoam",
                        "electric_seafoam_167",
                        "encore_face_background_electric_seafoam",
                        "episodeshortcutcardhome_progress_bar_highlight",
                        "fluorescent_green_176",
                        "fluorescent_green_blue_167",
                        "forest_decorative_subdued",
                        "green",
                        "green_100",
                        "green_135",
                        "green_157",
                        "green_180",
                        "green_25",
                        "green_55",
                        "green_75",
                        "green_blue_100",
                        "green_blue_135",
                        "green_blue_155",
                        "green_blue_180",
                        "green_desat_135",
                        "green_desat_155",
                        "green_focus",
                        "home_green_highlight",
                        "green_light",
                        "jellyfish_default_top",
                        "library_chip_wrapped_border_color_2",
                        "light_base_essential_brightaccent",
                        "light_base_essential_positive",
                        "light_base_text_brightaccent",
                        "light_base_text_positive",
                        "light_brightaccent_background_base",
                        "light_brightaccent_background_highlight",
                        "light_brightaccent_decorative_subdued",
                        "light_inverteddark_essential_brightaccent",
                        "light_inverteddark_text_brightaccent",
                        "light_invertedlight_essential_brightaccent",
                        "light_invertedlight_text_brightaccent",
                        "light_mutedaccent_essential_brightaccent",
                        "light_mutedaccent_text_brightaccent",
                        "light_positive_background_base",
                        "light_positive_background_highlight",
                        "light_positive_decorative_subdued",
                        "local_files_fill",
                        "megaphonelight_base_essential_positive",
                        "megaphonelight_positive_background_base",
                        "megaphonelight_positive_background_highlight",
                        "megaphonelight_positive_decorative_subdued",
                        "neon_green",
                        "neon_green_176",
                        "neongreen_decorative_subdued",
                        "overtimedark_base_essential_brightaccent",
                        "overtimedark_base_essential_positive",
                        "overtimedark_base_text_brightaccent",
                        "overtimedark_base_text_positive",
                        "overtimedark_brightaccent_background_base",
                        "overtimedark_brightaccent_background_highlight",
                        "overtimedark_brightaccent_decorative_subdued",
                        "overtimedark_inverteddark_essential_brightaccent",
                        "overtimedark_inverteddark_text_brightaccent",
                        "overtimedark_invertedlight_essential_brightaccent",
                        "overtimedark_invertedlight_text_brightaccent",
                        "overtimedark_mutedaccent_essential_brightaccent",
                        "overtimedark_mutedaccent_text_brightaccent",
                        "overtimedark_positive_background_base",
                        "overtimedark_positive_background_highlight",
                        "overtimedark_positive_decorative_subdued",
                        "playable_filter_color_2",
                        "quicksilverlight_positive_background_base",
                        "quicksilverlight_positive_background_highlight",
                        "quicksilverlight_positive_decorative_subdued",
                        "s4pdark_base_essential_positive",
                        "s4pdark_base_text_positive",
                        "s4pdark_positive_background_base",
                        "s4pdark_positive_background_highlight",
                        "s4pdark_positive_decorative_subdued",
                        "s4pdark_warning_background_highlight",
                        "s4plight_positive_background_base",
                        "s4plight_positive_background_highlight",
                        "s4plight_positive_decorative_subdued",
                        "spotify_green_157",
                        "spotifybrand_decorative_base",
                        "spotifybrand_essential_base",
                        "spotifybrand_text_base",
                        "spotifybrandalternate_background_base",
                        "spotifybrandalternate_background_highlight",
                        "spotifybrandalternate_decorative_subdued",
                        "studiolight_base_essential_positive",
                        "studiolight_positive_background_base",
                        "studiolight_positive_background_highlight",
                        "studiolight_positive_decorative_subdued",
                        "view_all_results_text",
                        "yourspotify_icon_check_alt_fill" -> accentColor
                        "accent_material_light",
                        "adanalyticslight_base_essential_positive",
                        "adanalyticslight_base_text_brightaccent",
                        "adanalyticslight_invertedlight_essential_brightaccent",
                        "adanalyticslight_invertedlight_text_brightaccent",
                        "adanalyticslight_positive_decorative_subdued",
                        "advertisinglight_base_text_positive",
                        "anchorlight_base_text_positive",
                        "bar_background_start_color",
                        "call_notification_answer_color",
                        "cat_accessory_focused_disabled",
                        "cat_button_primary_background_disabled",
                        "cat_dialog_button_background_positive_disabled",
                        "dark_invertedlight_text_brightaccent",
                        "design_default_color_secondary",
                        "design_default_color_secondary_variant",
                        "entry_point_card_text",
                        "forest",
                        "forest_75",
                        "forest_background_base",
                        "green_blue_25",
                        "green_blue_55",
                        "green_blue_75",
                        "green_blue_desat_100",
                        "green_blue_desat_114",
                        "green_blue_desat_135",
                        "green_blue_desat_155",
                        "green_blue_desat_25",
                        "green_blue_desat_55",
                        "green_blue_desat_75",
                        "green_dark",
                        "green_desat_100",
                        "green_desat_25",
                        "green_desat_55",
                        "green_desat_75",
                        "material_blue_grey_800",
                        "material_blue_grey_900",
                        "material_blue_grey_950",
                        "material_deep_teal_200",
                        "material_deep_teal_500",
                        "megaphonelight_base_text_positive",
                        "neongreen_background_base",
                        "preference_fallback_accent_color",
                        "quicksilverlight_base_essential_positive",
                        "quicksilverlight_base_text_positive",
                        "s4plight_base_text_positive",
                        "spearmint",
                        "spearmint_114",
                        "spearmint_background_base",
                        "spearmint_decorative_subdued",
                        "studiolight_base_text_positive",
                        "visual_differentiation_emerald_green",
                        "yellow_green_25",
                        "yellow_green_55",
                        "yellow_green_desat_25",
                        "yellow_green_desat_55",
                        "yellow_green_desat_75" -> accentColorSecondary
                        "adanalyticslight_brightaccent_background_press",
                        "adanalyticslight_positive_background_press",
                        "advertisingdark_positive_background_press",
                        "advertisinglight_positive_background_press",
                        "anchorlight_positive_background_press",
                        "bg_pressed",
                        "cat_accessory_green_pressed",
                        "creatordark_positive_background_press",
                        "creatorlight_positive_background_press",
                        "dark_brightaccent_background_press",
                        "dark_positive_background_press",
                        "light_brightaccent_background_press",
                        "light_positive_background_press",
                        "megaphonelight_positive_background_press",
                        "overtimedark_brightaccent_background_press",
                        "overtimedark_positive_background_press",
                        "quicksilverlight_positive_background_press",
                        "s4pdark_positive_background_press",
                        "s4plight_base_essential_positive",
                        "s4plight_positive_background_press",
                        "spotifybrand_2_background_press",
                        "spotifybrand_2_alternate_background_press",
                        "spotifybrandalternate_background_press",
                        "studiolight_positive_background_press" -> accentColorPressed
                        else -> continue
                    }
            }
        }
    }
}
