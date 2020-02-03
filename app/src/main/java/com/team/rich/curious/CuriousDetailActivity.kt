package com.team.rich.curious

import android.Manifest
import android.content.pm.PackageManager
import android.hardware.Camera
import android.os.Build
import android.os.Bundle
import android.view.SurfaceHolder
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_curious_detail.*
import java.io.IOException


class CuriousDetailActivity : AppCompatActivity(), SurfaceHolder.Callback{
    var mCamera: Camera? = null
    private lateinit var mCameraHolder : SurfaceHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_curious_detail)
        supportActionBar?.hide()

        mCamera = Camera.open(Camera.CameraInfo.CAMERA_FACING_FRONT)
        mCamera!!.setDisplayOrientation(90)
        // surfaceview setting
        mCameraHolder = camera_detail_forward.holder
        mCameraHolder.addCallback(this)
        mCameraHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS)
    }

    override fun onStart() {
        super.onStart()
        checkPermissionCamera()
    }

    private fun checkPermissionCamera() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { // 마시멜로우 버전과 같거나 이상이라면
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                || checkSelfPermission(Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED
            ) {
                if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                    Toast.makeText(this, "카메라 사용을 위해 필요", Toast.LENGTH_SHORT).show()
                }
                requestPermissions(
                    arrayOf(
                        Manifest.permission.CAMERA,
                        Manifest.permission.RECORD_AUDIO
                    ),
                    2 //체크해야될 권한 갯수
                )
            }
        }
    }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
        if (mCameraHolder.getSurface() == null) {
            return
        }
        try {
            mCamera!!.stopPreview()
        } catch (e: Exception ) {

        }
        val parameters = mCamera!!.parameters
        val focusModes = parameters.supportedFocusModes
        if (focusModes.contains(Camera.Parameters.FOCUS_MODE_AUTO)) {
            parameters.focusMode = Camera.Parameters.FOCUS_MODE_AUTO
        }
        mCamera!!.parameters = parameters
        try {
            mCamera!!.setPreviewDisplay(mCameraHolder)
            mCamera!!.startPreview()
        } catch (e : Exception ) {

        }

    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        if (mCamera != null) {
            mCamera!!.stopPreview()
            mCamera!!.release()
            mCamera = null
        }
    }

    override fun surfaceCreated(holder: SurfaceHolder?) {
        try {
            if (mCamera == null) {
                mCamera!!.setPreviewDisplay(holder)
                mCamera!!.startPreview()
            }
        } catch (e: IOException) {

        }

    }
}
