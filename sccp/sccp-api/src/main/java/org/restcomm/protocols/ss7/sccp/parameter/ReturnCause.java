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

package org.restcomm.protocols.ss7.sccp.parameter;

/**
 * Return cause values parameter for connectionless message
 *
 * @author baranowb
 * @author sergey vetyutnev
 */
public interface ReturnCause extends Parameter {

    int PARAMETER_CODE = 0xB;

    /**
     * Gets the value of this parameter.
     *
     * @return the value of this parameter.
     */
    ReturnCauseValue getValue();

    /**
     * @return the digital value of a parameter
     */
    int getDigitalValue();

}