/*
 * Copyright (c) 2015 Ushahidi.
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Affero General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program in the file LICENSE-AGPL. If not, see
 * https://www.gnu.org/licenses/agpl-3.0.html
 */

package com.ushahidi.android.domain.repository;

import com.addhen.android.raiburari.domain.repository.Repository;
import com.ushahidi.android.domain.entity.Deployment;

import rx.Observable;

/**
 * Repository for manipulating {@link Deployment} data
 *
 * @author Ushahidi Team <team@ushahidi.com>
 */
public interface DeploymentRepository extends Repository<Deployment> {

    /**
     * Get an {@link Deployment} by its status.
     *
     * @param status The deployment status to be used for retrieving deployment data.
     */
    Observable<Deployment> getByStatus(final Deployment.Status status);
}
