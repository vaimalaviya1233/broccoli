package com.flauschcode.broccoli.di;

import com.flauschcode.broccoli.backup.RestoreService;
import com.flauschcode.broccoli.backup.BackupService;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface ServiceModule {

    @ContributesAndroidInjector
    BackupService backupService();

    @ContributesAndroidInjector
    RestoreService restoreService();

}