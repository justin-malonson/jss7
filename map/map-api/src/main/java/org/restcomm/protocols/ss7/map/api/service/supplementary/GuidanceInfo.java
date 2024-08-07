/*
 * TeleStax, Open Source Cloud Communications  Copyright 2012.
 * and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: https://www.fsf.org.
 */

package org.restcomm.protocols.ss7.map.api.service.supplementary;

/**
 *
<code>
GuidanceInfo ::= ENUMERATED { enterPW (0), enterNewPW (1), enterNewPW-Again (2)}
-- How this information is really delivered to the subscriber
-- (display, announcement, ...) is not part of this
-- specification.
</code>
 *
 *
 * @author sergey vetyutnev
 *
 */
public enum GuidanceInfo {
    enterPW(0), enterNewPW(1), enterNewPWAgain(2);

    private int code;

    private GuidanceInfo(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static GuidanceInfo getInstance(int code) {
        switch (code) {
            case 0:
                return GuidanceInfo.enterPW;
            case 1:
                return GuidanceInfo.enterNewPW;
            case 2:
                return GuidanceInfo.enterNewPWAgain;
            default:
                return null;
        }
    }
}
