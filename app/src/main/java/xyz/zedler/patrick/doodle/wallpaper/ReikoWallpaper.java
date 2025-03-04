/*
 * This file is part of Doodle Android.
 *
 * Doodle Android is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Doodle Android is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Doodle Android. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (c) 2020-2021 by Patrick Zedler
 */

package xyz.zedler.patrick.doodle.wallpaper;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader.TileMode;
import androidx.annotation.NonNull;
import xyz.zedler.patrick.doodle.Constants.WALLPAPER;
import xyz.zedler.patrick.doodle.R;
import xyz.zedler.patrick.doodle.drawable.SvgDrawable;
import xyz.zedler.patrick.doodle.drawable.SvgDrawable.SvgObject;

public class ReikoWallpaper extends BaseWallpaper {

  @NonNull
  @Override
  public String getName() {
    return WALLPAPER.REIKO;
  }

  @Override
  public int getThumbnailResId() {
    return R.drawable.selection_reiko;
  }

  @Override
  public SvgDrawable getPreparedSvg(SvgDrawable svgDrawable, int variant, boolean isNightMode) {
    if (isNightMode) {
      if (variant == 1) {
        setKidneyGradientReiko(svgDrawable, "#a0b0fb", "#d8d4fe");
      } else if (variant == 2) {
        setKidneyGradientReiko(svgDrawable, "#eb902b", "#ecc12f");
      }
    } else {
      if (variant == 1) {
        setKidneyGradientReiko(svgDrawable, "#a0b0fb", "#d8d4fe");
      } else if (variant == 2) {
        setKidneyGradientReiko(svgDrawable, "#ff931e", "#fbc318");
      }
    }
    return svgDrawable;
  }

  @NonNull
  @Override
  public WallpaperVariant[] getVariants() {
    return new WallpaperVariant[]{
        new WallpaperVariant(
            R.raw.wallpaper_reiko1,
            "#cbcbef",
            "#fe7a9a",
            "#abe3e0",
            true,
            false
        ),
        new WallpaperVariant(
            R.raw.wallpaper_reiko2,
            "#fef7ed",
            "#fea31c",
            "#e0342b",
            true,
            false
        )
    };
  }

  @NonNull
  @Override
  public WallpaperVariant[] getDarkVariants() {
    return new WallpaperVariant[]{
        new WallpaperVariant(
            R.raw.wallpaper_reiko1_dark,
            "#0e032d",
            "#a181de",
            "#8fe5de",
            false,
            true
        ),
        new WallpaperVariant(
            R.raw.wallpaper_reiko2_dark,
            "#0e1f3b",
            "#a0b0fb",
            "#c6433a",
            false,
            true
        )
    };
  }

  private static void setKidneyGradientReiko(SvgDrawable svgDrawable, String start, String end) {
    int colorStart = Color.parseColor(start);
    int colorEnd = Color.parseColor(end);
    SvgObject kidneyFront = svgDrawable.requireObjectById("kidney_front");
    kidneyFront.shader = new LinearGradient(
        700, 0, 1100, 0, colorStart, colorEnd, TileMode.CLAMP
    );
    kidneyFront.isRotatable = true;
    SvgObject kidneyBack = svgDrawable.requireObjectById("kidney_back");
    kidneyBack.shader = new LinearGradient(
        400, 0, 800, 0, colorStart, colorEnd, TileMode.CLAMP
    );
    kidneyBack.isRotatable = true;
  }
}