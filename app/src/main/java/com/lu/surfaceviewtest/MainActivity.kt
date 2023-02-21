package com.lu.surfaceviewtest

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Color
import android.hardware.Camera
import android.hardware.Camera.CameraInfo.CAMERA_FACING_BACK
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import pub.devrel.easypermissions.EasyPermissions


class MainActivity : AppCompatActivity(), SurfaceHolder.Callback {
    lateinit var mHolder : SurfaceHolder
    lateinit var mCamera : Camera
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        if (!EasyPermissions.hasPermissions(this, Manifest.permission.CAMERA)) {
//            // 已经有权限
////            local()
//        } else {
//            // 没有权限，现在请求他们
//            //只有用户首次安装时拒绝了权限，才会在下次申请时弹出 "此app需要xxx权限"提示框
//            EasyPermissions.requestPermissions(this@MainActivity, "此app需要获取xxx权限", 1, Manifest.permission.CAMERA)
//        }

        val hasWriteStoragePermission: Int =

            ContextCompat.checkSelfPermission(application, Manifest.permission.CAMERA)

        if (hasWriteStoragePermission == PackageManager.PERMISSION_GRANTED) {

            //拥有权限，执行操作
            val surfaceView = SurfaceView(this)
            surfaceView.setBackgroundColor(Color.parseColor("#ff0000"))
            mHolder = surfaceView.holder
            mHolder.addCallback(this)
            (findViewById(R.id.rooot) as ViewGroup).addView(surfaceView, ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))

            }else {

          //没有权限，向用户请求权限

           ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 1)

        }
    }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {

    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        mCamera.stopPreview()
        mCamera.release()
    }

    override fun surfaceCreated(holder: SurfaceHolder?) {
        mCamera = Camera.open(CAMERA_FACING_BACK)
        mCamera.setPreviewDisplay(holder)
        mCamera.startPreview()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        //通过requestCode来识别是否同一个请求

        if (requestCode == 1) {

            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                // 获取到权限
                val surfaceView = SurfaceView(this)
                surfaceView.setBackgroundColor(Color.parseColor("#ff0000"))
                mHolder = surfaceView.holder
                mHolder.addCallback(this)
                (findViewById(R.id.rooot) as ViewGroup).addView(surfaceView, ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))

            } else {

                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        this,
                        Manifest.permission.CAMERA
                    )
                ) {

                    //用户不同意，向用户展示该权限作用

                } else {

                    //用户j禁止不在弹出

                }

            }

        }
    }
}