/*
 * Copyright (c) 2015 Ushahidi Inc
 *
 * This program is free software: you can redistribute it and/or modify it under
 *  the terms of the GNU Affero General Public License as published by the Free
 *  Software Foundation, either version 3 of the License, or (at your option)
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful, but WITHOUT
 *  ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 *  FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program in the file LICENSE-AGPL. If not, see
 *  https://www.gnu.org/licenses/agpl-3.0.html
 */

package com.ushahidi.android.data.entity;

import com.addhen.android.raiburari.data.entity.DataEntity;

import java.util.Date;

/**
 * Tag data entity
 *
 * @author Ushahidi Team <team@ushahidi.com>
 */
public class TagEntity extends DataEntity {

    private Long mParentId;

    private String mTag;

    private String mSlug;

    private String mColor;

    private Type mType;

    private String mIcon;

    private String mDescription;

    private int mPriority;

    private Date mCreated;

    private Long mDeploymentId;

    public Long getParentId() {
        return mParentId;
    }

    public void setParentId(Long parentId) {
        mParentId = parentId;
    }

    public String getTag() {
        return mTag;
    }

    public void setTag(String tag) {
        mTag = tag;
    }

    public String getSlug() {
        return mSlug;
    }

    public void setSlug(String slug) {
        mSlug = slug;
    }

    public Type getType() {
        return mType;
    }

    public void setType(Type type) {
        mType = type;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Date getCreated() {
        return mCreated;
    }

    public void setCreated(Date created) {
        mCreated = created;
    }

    public int getPriority() {
        return mPriority;
    }

    public void setPriority(int priority) {
        mPriority = priority;
    }

    public String getColor() {
        return mColor;
    }

    public void setColor(String mColor) {
        this.mColor = mColor;
    }

    public long getDeploymentId() {
        return mDeploymentId;
    }

    public void setDeploymentId(long deploymentId) {
        mDeploymentId = deploymentId;
    }

    public enum Type {
        CATEGORY("category"),
        STATUS("status");

        public final String value;

        Type(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    @Override
    public String toString() {
        return "Tag{" +
                "mParentId=" + mParentId +
                ", mTag='" + mTag + '\'' +
                ", mSlug='" + mSlug + '\'' +
                ", mColor='" + mColor + '\'' +
                ", mType=" + mType +
                ", mIcon='" + mIcon + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mPriority=" + mPriority +
                ", mCreated=" + mCreated +
                ", mDeploymentId=" + mDeploymentId +
                '}';
    }
}
