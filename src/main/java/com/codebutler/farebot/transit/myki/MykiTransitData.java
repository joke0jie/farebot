/*
 * MykiTransitData.java
 *
 * This file is part of FareBot.
 * Learn more at: https://codebutler.github.io/farebot/
 *
 * Copyright (C) 2016 Eric Butler <eric@codebutler.com>
 * Copyright (C) 2016 Michael Farrell <micolous+git@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.codebutler.farebot.transit.myki;

import android.net.Uri;
import android.support.annotation.NonNull;

import com.codebutler.farebot.transit.stub.StubTransitData;
import com.google.auto.value.AutoValue;

/**
 * Transit data type for Myki (Melbourne, AU).
 * <p>
 * This is a very limited implementation of reading Myki, because most of the data is stored in
 * locked files.
 * <p>
 * Documentation of format: https://github.com/micolous/metrodroid/wiki/Myki
 */
@AutoValue
public abstract class MykiTransitData extends StubTransitData {

    public static final String NAME = "Myki";

    @NonNull
    static MykiTransitData create(@NonNull String serialNumber) {
        return new AutoValue_MykiTransitData(serialNumber);
    }

    @NonNull
    @Override
    public abstract String getSerialNumber();

    @NonNull
    @Override
    public String getCardName() {
        return NAME;
    }

    @Override
    public Uri getMoreInfoPage() {
        return Uri.parse("https://micolous.github.io/metrodroid/myki");
    }
}
