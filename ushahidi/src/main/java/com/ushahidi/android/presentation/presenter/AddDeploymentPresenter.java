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

package com.ushahidi.android.presentation.presenter;

import com.addhen.android.raiburari.domain.exception.DefaultErrorHandler;
import com.addhen.android.raiburari.domain.exception.ErrorHandler;
import com.addhen.android.raiburari.domain.usecase.DefaultSubscriber;
import com.addhen.android.raiburari.presentation.presenter.Presenter;
import com.ushahidi.android.domain.usecase.deployment.AddDeploymentUsecase;
import com.ushahidi.android.presentation.exception.ErrorMessageFactory;
import com.ushahidi.android.presentation.model.DeploymentModel;
import com.ushahidi.android.presentation.model.mapper.DeploymentModelDataMapper;
import com.ushahidi.android.presentation.ui.view.AddDeploymentView;

import android.support.annotation.NonNull;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Ushahidi Team <team@ushahidi.com>
 */
public class AddDeploymentPresenter extends DefaultSubscriber<Long> implements Presenter {

    private final AddDeploymentUsecase mAddDeploymentUsecase;

    private final DeploymentModelDataMapper mDeploymentModelDataMapper;

    private AddDeploymentView mAddDeploymentView;

    @Inject
    public AddDeploymentPresenter(@Named("categoryAdd") AddDeploymentUsecase addDeploymentUsecase,
            DeploymentModelDataMapper deploymentModelDataMapper) {
        mAddDeploymentUsecase = addDeploymentUsecase;
        mDeploymentModelDataMapper = deploymentModelDataMapper;
    }

    @Override
    public void resume() {
        // Do nothing
    }

    @Override
    public void pause() {
        // Do nothing
    }

    @Override
    public void destroy() {
        mAddDeploymentUsecase.unsubscribe();
    }

    public void setView(@NonNull AddDeploymentView addDeploymentView) {
        mAddDeploymentView = addDeploymentView;
    }

    public void addDeployment(DeploymentModel deploymentModel) {
        mAddDeploymentView.hideRetry();
        mAddDeploymentView.showLoading();
        mAddDeploymentUsecase.setDeployment(mDeploymentModelDataMapper.map(deploymentModel));
        mAddDeploymentUsecase.execute(this);
    }

    private void showErrorMessage(ErrorHandler errorHandler) {
        String errorMessage = ErrorMessageFactory.create(mAddDeploymentView.getAppContext(),
                errorHandler.getException());
        mAddDeploymentView.showError(errorMessage);
    }

    @Override
    public void onCompleted() {
        mAddDeploymentView.hideLoading();
    }

    @Override
    public void onError(Throwable e) {
        mAddDeploymentView.hideLoading();
        showErrorMessage(new DefaultErrorHandler((Exception) e));
        mAddDeploymentView.showRetry();
    }

    @Override
    public void onNext(Long row) {
        mAddDeploymentView.onDeploymentSuccessfullyAdded(row);
    }
}