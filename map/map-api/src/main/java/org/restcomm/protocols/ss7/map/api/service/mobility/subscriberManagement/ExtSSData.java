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

package org.restcomm.protocols.ss7.map.api.service.mobility.subscriberManagement;

import java.io.Serializable;
import java.util.ArrayList;

import org.restcomm.protocols.ss7.map.api.primitives.MAPExtensionContainer;
import org.restcomm.protocols.ss7.map.api.service.supplementary.SSCode;
import org.restcomm.protocols.ss7.map.api.service.supplementary.SSSubscriptionOption;

/**
 *
 Ext-SS-Data ::= SEQUENCE { ss-Code SS-Code, ss-Status [4] Ext-SS-Status, ss-SubscriptionOption SS-SubscriptionOption
 * OPTIONAL, basicServiceGroupList Ext-BasicServiceGroupList OPTIONAL, extensionContainer [5] ExtensionContainer OPTIONAL, ...}
 *
 * Ext-BasicServiceGroupList ::= SEQUENCE SIZE (1..32) OF Ext-BasicServiceCode
 *
 *
 *
 * @author sergey vetyutnev
 *
 */
public interface ExtSSData extends Serializable {

    SSCode getSsCode();

    ExtSSStatus getSsStatus();

    SSSubscriptionOption getSSSubscriptionOption();

    ArrayList<ExtBasicServiceCode> getBasicServiceGroupList();

    MAPExtensionContainer getExtensionContainer();

}
